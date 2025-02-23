package entidades;

import Enums.Personagem;
import itens.ArmaPrincipal;
import jogo.Historia;
import jogo.Tools;

/**
 * Classe que representa o personagem Luffy no jogo. Implementa
 * o método de combate específico para Luffy, com a possibilidade de ativar o Gear 5
 */
public class Luffy extends Heroi {
    private boolean gear5;

    /**
     * Construtor
     *
     * @param nome
     * @param hp
     * @param forca
     * @param nivel
     * @param ouro
     */
    public Luffy(Personagem nome, int hp, int forca, int nivel, int ouro) {
        super(nome, hp, forca, nivel, ouro);
        this.gear5 = false;
    }

    /**
     * Método que realiza a luta entre Luffy e um NPC inimigo.
     * O NPC ataca com 80% de sua força, e Luffy pode ativar o Gear 5 quando sua vida
     * estiver abaixo ou igual 20% durante a luta contra Kaido, o que aumenta suas habilidades.
     *
     * @param npc O NPC inimigo
     * @return Retorna {@code false} se Luffy vencer o combate e o NPC for derrotado,
     *         e {@code true} se o combate continuar.
     */
    @Override
    public boolean atacar(NPC npc) {
        // Ataca primeiro o NPC
        Historia.combateTurno(npc);
        int ataque = (int) (npc.getForca() * 0.8);
        if (!this.recebeAtaque(ataque)) return false;

        // GEAR 5 VS KAIDO
        if (this.getHp() <= (this.getMaxHp() * 0.20) && npc.getNome().equals(Personagem.Kaido)) {
            Tools.playAudio("src/music/g5.wav");
            Tools.pausar();
            if (!this.gear5) ativarGear5(npc);
        }

        // Ataca o Herói
        Historia.combateTurno(this);
        ataque = this.tipoAtaque();
        if (!npc.recebeAtaque(ataque)) {
            this.subirNivel(npc);
            return false;
        }
        Tools.pausar();
        return true;
    }

    /**
     * Método que ativa o Gear 5 de Luffy durante o combate, caso ele tenha menos de 20% de vida
     *
     * @param npc O NPC (Kaido)
     */
    private void ativarGear5(NPC npc) {
        this.gear5 = true;
        this.setAtaqueEspecialUsado(false);

        // Animação dos tambores da libertação
        for (int i = 10; i > 0; i--) {
            Tools.limpar();
            System.out.printf("                %sDoom! %sDoom! %sDoom!" + "\n".repeat(i), Tools.color.YELLOW_BRIGHT,
                    Tools.color.WHITE_BRIGHT, Tools.color.YELLOW_BRIGHT);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Historia G5
        Historia.kaidoLuffyG5();

        // Aumentar força
        this.setForca(this.getForca() + 10);
        // Aumentar vida (HP)
        this.setMaxHp(this.getMaxHp() + 10);
        this.setHp(this.getHp() + 50);
        // Aumeta vida do NPC
        npc.setForca(npc.getForca() + 10);
        npc.setHp(npc.getHp() + 100);
        Historia.kaidoDragao();
        // Arma Principal
        this.setArmaPrincipal(new ArmaPrincipal("Nika ☀️", 0, 50, 150, Personagem.Luffy));

    }
}