package jogo;

public class Historia {

    // Ato 1: A chegada a Wano e a infiltração

    public static void intro() {
        String narracaoInicial = """
                O vento sopra forte enquanto o Thousand Sunny navega em direção às costas de Wano, um país isolado e oprimido pelo shogun Orochi e pelo imperador pirata Kaido.
                
                Luffy e a sua tripulação chegaram aqui com um único objetivo: libertar Wano da sua tirania e derrotar a Kaido.
                Mas o caminho não será fácil. Wano é um lugar perigoso, cheio de samurais leais a Orochi e bestas poderosas ao serviço de Kaido.
                Estás pronto para embarcar nesta aventura?
                
                """;
        System.out.print(narracaoInicial);
    }

    public static void escolhaPersonagem() {
        String escolhaPersonagem = """
                Antes de começares, deves escolher com quem queres iniciar esta aventura.
                
                Serás o Luffy, o capitão destemido que sonha em ser o Rei dos Piratas?
                Ou preferes o Zoro, o espadachim implacável que corta os inimigos com precisão mortal?
                Ou o Sanji, o cozinheiro galante que luta com os seus poderosos pontapés.
                
                A escolha é tua...
                
                """;
        System.out.print(escolhaPersonagem);
    }

    public static void luffyIntro() {
        String introducaoLuffy = """
                'Ei, tu! Escolheste-me? Boa decisão! Eu sou Luffy, o futuro Rei dos Piratas!
                Vamos derrotar o Kaido e libertar Wano! Não te preocupes, eu protejo-te!'
                
                Luffy é o capitão destemido dos Chapéus de Palha, conhecido pela sua incrível força e pela sua vontade inabalável.
                Com o seu poder da Gomu Gomu no Mi, ele estica o corpo como borracha para esmagar os inimigos.
                
                Estás pronto para partir nesta aventura com ele?
                
                """;
        System.out.print(introducaoLuffy);
    }

    public static void zoroIntro() {
        String introducaoZoro = """
                'Então escolheste-me? Bom, não te vou dececionar.
                Eu sou Zoro, o espadachim dos Chapéus de Palha, e vou cortar todos os que se atravessarem no nosso caminho.
                Kaido e Orochi não sabem com quem estão a lidar.'
                
                Zoro é um mestre das três espadas, capaz de derrotar inimigos com uma precisão mortal.
                Com a sua técnica Santoryu, ele é uma força imparável no campo de batalha.
                
                Preparado para lutar ao seu lado?
                
                """;
        System.out.print(introducaoZoro);
    }

    public static void sanjiIntro() {
        String introducaoSanji = """
                'Ah, escolheste-me? Bem, não podias ter feito melhor.
                Eu sou Sanji, o cozinheiro dos Chapéus de Palha, e os meus pontapés vão mandar Kaido e os seus capangas para o chão.
                E depois da batalha, preparo-te um banquete!'
                
                Sanji é um lutador elegante e poderoso, especializado em artes marciais com os pés.
                Com o seu Diable Jambe, ele pode incendiar os inimigos com chamas intensas.
                
                Pronto para saborear a vitória com ele?
                
                """;
        System.out.print(introducaoSanji);
    }

    public static void vendedorIntro() {
        String introVendedor = """
                'Oi, oi, oi! Parece que temos um aventureiro destemido por aqui!'
                'Eu sou Barry, o vendedor mais confiável de Wano! Tenho tudo o que precisas para sobreviver nesta terra perigosa.
                Armas, poções, consumível de combate... Se precisas, eu tenho!'
                
                'Mas cuidado, os melhores itens não são de graça. Tens ouro suficiente?'
                
                """;
        System.out.print(introVendedor);
    }

    public static void vendedorPergunta(){
        "'Então, o que vais levar? Escolhe com sabedoria, aventureiro. Wano não perdoa os despreparados.'\n";

    }

    String primeiraMissao = "Chegaste à vila dos kozuki, um lugar que outrora foi próspero, mas que agora está mergulhado na miséria sob o jugo de Orochi.\n" +
            "Os aldeãos vivem com medo, e os soldados de Orochi patrulham as ruas.\n" +
            "A tua primeira missão é ajudar os aldeãos a esconderem-se enquanto te infiltra na vila.\n" +
            "Cuidado com os soldados! Se te descobrirem, terás de lutar.\n";

    String combateSoldados = "Oh não! Um grupo de soldados viu-te. Não tens outra opção senão lutar.\n" +
            "Usa as tuas habilidades para os derrotar e proteger os aldeãos.\n" +
            "Lembra-te, cada personagem tem ataques únicos. Escolhe sabiamente!\n";

    String encontroMomonosuke = "Depois de ajudares os aldeãos, encontras o Momonosuke, o jovem herdeiro dos kozuki, e o Kin'emon, o seu leal samurai.\n" +
            "Eles explicam-te que Wano está sob o controlo de Kaido e Orochi e que precisam da tua ajuda para libertar o país.\n" +
            "Momonosuke pede-te que te juntes à resistência e lutas pela liberdade de Wano.\n" +
            "Aceitarás o seu pedido?\n";


    // Ato 2: A resistência e as alianças
    String narracaoResistencia = "Com o Momonosuke e o Kin'emon ao teu lado, começas a reunir aliados para a resistência.\n" +
            "Mas Kaido e Orochi não vão ficar de braços cruzados.\n" +
            "Aumentaram a opressão, e os perigos são cada vez maiores.\n" +
            "Tens de agir rapidamente antes que seja tarde demais.\n";

    String missaoMinas = "Zoro, precisamos de ti nas minas de prisioneiros.\n" +
            "Kaido escravizou centenas de pessoas, forçando-as a trabalhar em condições desumanas.\n" +
            "A tua missão é infiltrar-te nas minas, libertar os prisioneiros e enfrentar os guardas.\n" +
            "Mas cuidado, há rumores de que um dos Tobiroppo, os poderosos subordinados de Kaido, está no comando das minas.\n";

    String combateTobiroppo = "Alerta! Um Tobiroppo apareceu. Este inimigo é poderoso e não hesitará em acabar contigo.\n" +
            "Usa todas as tuas habilidades para o derrotar e libertar os prisioneiros.\n" +
            "Não desistas!\n";

    String missaoProtecao = "Sanji, os aldeãos estão em perigo.\n" +
            "Um grupo de soldados de Orochi está a atacar a vila, e precisam da tua ajuda para os proteger.\n" +
            "Usa as tuas habilidades de combate e o teu engenho para manter os aldeãos a salvo.\n" +
            "Não deixes que ninguém sofra mais sob o jugo de Orochi!\n";

    // Ato 3: O assalto a Onigashima
    String narracaoAssalto = "Chegou o momento. A resistência está pronta, e é hora de lançar o ataque final a Onigashima, a fortaleza de Kaido.\n" +
            "Esta será a batalha mais grande e perigosa de todas.\n" +
            "Estás pronto para enfrentar Kaido e libertar Wano de uma vez por todas?\n";

    String missaoInvasao = "Onigashima está fortemente defendida.\n" +
            "Tens de abrir caminho através das defesas de Kaido e chegar até ele.\n" +
            "Mas cuidado, os inimigos são numerosos e poderosos.\n" +
            "Usa todas as tuas habilidades e não subestimes os teus oponentes.\n";

    String combateTobiroppoOnigashima = "Cuidado! Os Tobiroppo apareceram.\n" +
            "Estes inimigos são extremamente perigosos e não hesitarão em acabar contigo.\n" +
            "Usa todas as tuas habilidades e ataques especiais para os derrotar.\n" +
            "Não desistas!\n";

    String missaoResgate = "Luffy, o Momonosuke foi capturado pelo Kaido.\n" +
            "Tens de o resgatar antes que seja tarde demais.\n" +
            "Kaido é um inimigo formidável, mas não podes deixar que ele saia vitorioso.\n" +
            "Avança, liberta o Momonosuke e enfrenta o Kaido!\n";

    // Ato 4: A luta final contra Kaido
    String narracaoFinal = "Chegaste ao fim. Kaido está à tua frente, pronto para te destruir.\n" +
            "Mas não podes recuar. Wano depende de ti.\n" +
            "É hora de enfrentar o imperador pirata e libertar Wano da sua tirania.\n" +
            "Prepara-te para a batalha mais épica da tua vida!\n";

    String combateKaido = "Kaido é um inimigo como nenhum outro.\n" +
            "Tens de usar todas as tuas habilidades e ataques especiais para o derrotar.\n" +
            "Mas cuidado, Kaido tem várias fases de combate. Não te descuides!\n";

    String fase1 = "Kaido começa na sua forma humana, usando a sua força bruta para te atacar.\n" +
            "Tens de esquivar os seus golpes e contra-atacar com tudo o que tens.\n";

    String fase2 = "Kaido transforma-se num dragão gigante.\n" +
            "Os seus ataques são mais poderosos e devastadores.\n" +
            "Tens de ser rápido e preciso para evitar os seus ataques e encontrar uma oportunidade para contra-atacar.\n";

    String fase3 = "Kaido transforma-se na sua forma híbrida, combinando a força de um humano com o poder de um dragão.\n" +
            "Esta é a sua forma mais perigosa.\n" +
            "Tens de usar todas as tuas habilidades e ataques especiais para o derrotar.\n" +
            "Não desistas!\n";

    String vitoria = "Conseguiste! Kaido foi derrotado, e Wano está livre.\n" +
            "Os aldeãos agradecem-te pela tua coragem e sacrifício.\n" +
            "Cumpriste a tua promessa e libertaste Wano da sua tirania.\n" +
            "Parabéns, herói de Wano!\n";

    // Ato 5: Epílogo e desfecho
    String epilogo = "Com Wano libertado, é hora de continuar a tua viagem.\n" +
            "A tripulação do Chapéu de Palha zarpa em direção a novas aventuras, mas sempre se lembrará do tempo passado em Wano.\n" +
            "Momonosuke e os cidadãos de Wano agradecem-te pela tua ajuda e desejam-te boa sorte na tua jornada.\n" +
            "O mar espera por ti, e novas aventuras estão por vir.\n" +
            "Até à próxima, pirata!\n";
}
