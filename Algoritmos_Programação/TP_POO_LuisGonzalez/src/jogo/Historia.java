package jogo;

import entidades.Entidade;
import entidades.Heroi;
import entidades.NPC;
import itens.ConsumivelCombate;
import itens.ItemHeroi;
import itens.Pocao;

public class Historia {
    public static void logoIntro() {
        System.out.println(Tools.color.WHITE_BRIGHT + """
                
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣇⣿⡻⣮⡻⡿⣟⣩⣭⣿⣯⣭⣛⡿⡿⣏⡼⠿⢗⣙⠟⣛⡛⡛⣛⣛⣛⣛⡛⣿⣝⢛⣛⣛⣛⢿⣿⡿⠟⠻⣿⢛⣛⣛⣛⣛⡻⣿⢿⣛⣛⡿⣿⣿⣿⣿⡿⣟⢩⢛⣿
                        ⣿⣿⣿⡎⣵⣾⡿⢟⣛⣉⣛⣛⠿⣿⣶⡉⣴⡇⣿⣷⠀⣿⡇⡇⣿⡟⣥⣿⣅⣿⣿⣼⡇⣮⠹⣇⣿⣦⠀⢤⣶⡞⣿⢏⣵⣯⣑⢡⣿⢛⠿⣿⡙⣿⢟⡵⣪⣶⣷⣿⣿
                        ⣿⣿⡟⣼⢿⠋⠴⠿⠿⠿⠿⠿⠷⠌⢻⡿⡜⡇⢿⣟⣾⠿⡇⡧⣿⠧⣿⣿⣿⣿⣿⢼⡇⣿⠱⣏⠟⢁⠐⢀⡈⢃⣿⢸⣿⣿⣿⢸⡗⣾⡇⣿⠇⢡⡟⣴⣿⣿⣿⣿⣿
                        ⣿⠿⢐⣩⡥⣖⣒⣒⣒⣒⣒⣒⣒⣒⡢⣭⡕⠀⢛⡮⣝⢯⡃⡗⣯⠑⢛⡍⣿⣿⣿⢸⠇⣿⡁⣏⣄⠸⠐⠀⠃⡈⣟⠘⣛⢹⣿⢸⠇⣿⣶⣶⡆⡾⢐⠛⡀⠋⠠⢹⣿
                        ⣿⣿⠰⣆⡀⣿⠉⠀⠹⣿⡏⠁⠈⢹⡇⡰⢶⠀⡏⣶⢉⡶⢁⡏⣷⢁⣶⣀⣿⣿⣿⠸⠇⣿⢀⡇⣿⠀⢁⠀⠸⡇⡏⢰⣶⣸⣿⢈⠇⣿⠿⠿⠷⠹⠰⣶⠀⠀⠀⣸⣿
                        ⣿⣿⡆⢎⠥⠻⣀⠀⣀⠿⣇⡀⢀⡸⢣⡑⠃⡆⡱⢢⠣⡜⣁⡟⡤⢩⣿⣿⣿⣿⣿⠸⡁⣒⣡⣴⣿⣃⠀⠂⣹⡇⡹⢸⣿⣿⣿⢈⠆⣿⡇⢎⢰⡜⡁⢿⣿⡐⠀⠘⣿
                        ⣿⣿⣿⠌⠨⡑⣉⠛⡿⠦⠾⣟⢋⡐⠢⢁⢾⡇⢡⠃⡀⡱⠀⡟⡐⢂⠻⠿⠟⣿⣿⠰⠁⣿⣿⣿⣿⣷⠀⠄⣿⡇⡱⠘⠿⠿⢋⠠⠒⡌⢡⢊⢠⣿⣌⡀⠻⠡⢰⣶⣾
                        ⣏⣭⣵⢞⣱⠄⠠⠀⣨⣼⣖⣀⠠⢈⠴⣝⢷⣃⡂⣂⣣⣁⣃⡃⠁⠃⢘⣐⣂⣿⣏⣐⣁⡻⠛⠻⢟⣩⣴⣌⣛⣁⣂⡉⠂⡑⢨⣷⣅⣘⣀⣤⣿⣿⣿⡿⠀⣡⢈⣙⣿
                        ⣷⣯⠿⠂⠀⣢⣤⣤⣭⣿⣯⣥⣤⣤⣤⣀⠌⠍⠁⢀⣤⣤⣤⣤⣤⣬⣐⠀⡄⠀⣠⣤⣤⣤⣤⣬⣀⠠⠀⠀⣠⣤⣤⣤⣤⣤⡁⢀⠠⠤⢤⣤⠤⠄⠠⢐⣤⣤⣤⣤⣼
                        ⣿⣿⣷⣤⣥⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣶⣾⣿⣿⣿⣿⣿⣿⣿⣷⣮⣄⣁⣂⣢⣼⣶⣿⣿⣿⣿⣿⣿
                
                """ + Tools.color.RESET);
        Tools.pausar();
    }

    // *********************************************** INTRO ***********************************************
    public static void intro() {
        System.out.print(Tools.color.WHITE_BRIGHT + """
                
                ⛩️ Bem-vindo ao País de Wano! ⛩️
                
                Uma terra isolada do resto do mundo, onde samurais ainda caminham pelas ruas e as antigas tradições permanecem vivas... 
                ou pelo menos, costumavam permanecer.
                
                Nos últimos 20 anos, este país mudou drasticamente sob o governo do shogun Kurozumi Orochi 👺 
                e a influência do Yonkou Kaido 🐉. 
                
                O que antes era uma nação próspera, tornou-se um lugar de sofrimento e desigualdade.
                
                """ + Tools.color.RESET);

        Tools.pausar();

        System.out.print(Tools.color.WHITE_BRIGHT + """
                
                Luffy e a sua tripulação chegaram aqui com um único objetivo: libertar Wano 🏯 da sua tirania e derrotar a Kaido 🏴‍☠️.
                
                Mas o caminho não será fácil. Wano é um lugar perigoso, cheio de samurais leais a Orochi e bestas poderosas ao serviço de Kaido 🐉.
                
                Estás pronto para embarcar nesta aventura?
                
                """ + Tools.color.RESET);

        Tools.pausar();
    }

    // *********************************************** ESCOLHA PERSONAGEM ***********************************************
    public static void escolhaPersonagem() {
        System.out.print(Tools.color.WHITE_BRIGHT + """
                
                Antes de começares, deves escolher com quem queres iniciar esta aventura.
                
                """ + Tools.color.RESET);

        Tools.pausar();

        System.out.print(Tools.color.YELLOW + """
                    ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⣩⡔⡨⠋⢀⠄⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣮⡏⠣⠱⠱⣈⡻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⣡⡾⠋⡜⠔⣳⠂⡼⠿⢛⣛⣿⣿⣿⣿⣿⣿⣿⣛⣛⣛⡛⠿⠟⢠⠠⠧⣧⢹⣮⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣽⣿⢋⣼⠏⢀⠋⢘⣈⣥⣶⣾⠿⠟⣛⡛⠭⠭⠽⠿⠟⠟⠻⠟⠛⠉⠀⢠⣦⣄⡃⠁⢡⢹⣷⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢣⡾⠁⣠⣴⣦⠀⠉⠉⠉⠈⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠙⠛⠳⠦⣀⠪⢿⣀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠱⣋⣴⣿⠟⣫⠝⠃⠀⠀⠀⠀⠀⢀⣶⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣤⡔⢦⣷⣌⠻⡄⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢻⣿⣿⠟⣡⣾⡿⢛⠥⠊⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⣷⣍⠻⣷⠌⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠉⠋⠶⠿⠋⠔⠁⠀⠀⠀⠀⠀⢠⠀⠀⣴⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⢷⡘⢷⡦⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡇⠀⣸⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣦⠻⣆⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⣴⣿⢦⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠇⠠⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⣿⣿⣧⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⢠⡀⢣⠱⡙⣦⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⢃⣼⡟⠐⠁⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⠄⢘⠿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⡿⠛⣉⡄⠀⠀⢈⡀⠀⠀⠀⠀⠀⠀⠋⢀⢣⠁⢸⣷⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⠃⣾⡟⠀⠀⣠⣴⠂⠀⠀⠀⠀⠀⠘⣉⣥⡄⢰⣤⣍⡙⠿⣿⣿⠟⣿⣿⣿⡀⠀⣴⣿⣿⣇⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⢺⣦⣿⣧⠻⣦⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡇⣼⣿⠃⢠⣾⣿⠟⠀⠀⠀⠀⠀⠀⣾⣿⣿⣷⡸⣿⣿⣶⣷⣮⣿⣦⡙⣿⣿⡇⢰⣿⡿⠟⠉⠀⣸⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⡇⣿⣇⢸⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡇⣿⣿⢸⣾⣻⠏⠀⠀⠀⠀⠀⠀⠸⣿⣿⣟⠻⠀⠉⠙⠻⢻⣿⣿⡻⠀⣹⣿⣧⣼⠏⠀⠈⢀⣀⣉⠙⢿⠀⠀⡄⠀⠀⠀⠀⢢⣄⠙⠟⣿⣸⣿⡌⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡇⣸⣿⡾⠋⢁⣀⡄⠀⠀⠀⠀⠀⠀⣿⠟⠁⣠⣶⣟⣉⣤⣸⣿⣿⠀⣾⣿⣿⣿⣷⣤⠦⠶⠶⠿⠟⢋⣤⠀⢰⠀⠀⠀⠀⠀⢸⣿⣿⣦⣷⡞⣿⠃⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⢩⠁⣻⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠠⡀⢸⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣶⣜⣧⣽⣿⠿⠯⠿⠷⠾⢛⣛⣈⣉⠠⣿⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣎⣿⠘⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣾⡐⢹⣯⢻⣿⣿⣿⠁⠀⢸⠀⠀⠀⠹⡆⠈⣡⣥⣴⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣾⣿⣿⡿⣿⣿⡿⣿⡇⡿⠀⠀⠀⠀⣆⠸⣿⣿⣿⣿⢸⣿⠇⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡇⢼⣿⡌⡏⢿⠻⣷⠀⢿⠃⠤⡄⢰⠀⣼⣿⢹⣿⡟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⢸⣿⠇⢛⡇⡇⢀⠀⡄⠀⢻⣶⣿⣿⣿⡇⣿⡟⢰⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⡘⣿⣷⠘⡈⢦⠑⡐⢘⠸⠐⠈⡆⠇⢹⣙⡂⠻⠧⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣛⣛⣭⣥⢠⣴⣆⡿⢠⢁⠁⠀⡇⣷⡄⠙⠻⠟⡻⢠⠿⢡⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣷⡜⠛⣧⡀⢄⣷⣶⣾⣆⠣⡐⢬⡘⡌⢿⡇⢾⣿⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣿⡿⢃⠂⡨⠔⡰⢡⣿⣤⣀⢀⡼⢡⣿⢡⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣌⠺⣿⣢⠹⣅⠫⡋⠓⠌⡒⠖⠙⡌⠻⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⢡⠎⡨⠴⢂⡴⢿⣿⣿⢿⠟⣵⠏⢣⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣝⠻⣷⡌⠳⢤⣴⣶⣾⣿⣷⣌⡃⢈⡛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⢁⡴⠋⢀⣶⣎⠉⣀⡠⢊⠅⣡⡾⠋⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣬⣛⠿⡿⣿⡙⢀⠫⣐⠈⣹⡄⠉⠓⠌⣍⣛⠻⠿⠿⠿⠛⣛⣛⡩⢄⠠⠒⠋⠀⣰⡌⠅⣋⡿⢿⡶⢣⢾⠟⣡⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⡚⠿⣶⣄⠴⣿⣿⣷⣬⡄⡱⣦⣭⣐⠻⢿⡿⠯⢉⣁⣤⣴⢂⠇⣼⣶⣿⣿⣿⡥⢖⣡⡞⠁⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢓⣊⠉⢛⠻⢯⣙⣻⡇⡇⣿⣿⣿⣿⣶⣶⣿⣿⣿⣿⠇⣾⢰⣻⠿⠿⠛⣑⠒⠛⣥⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢁⡼⠋⠀⠀⠀⠀⠀⠈⠙⢠⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢰⣿⠈⠤⠶⠓⠛⠛⢷⣆⡌⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⠟⣋⣥⣶⣤⣭⡍⢰⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⢡⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠘⣿⡄⠀⠀⠀⠀⠀⠀⠘⣷⣦⣙⠻⢛⣋⣙⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                                                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                  Serás o Luffy, o capitão destemido que sonha em ser o Rei dos Piratas?
                
                """ + Tools.color.RESET);

        Tools.pausar();

        System.out.print(Tools.color.GREEN + """
                
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣦⣽⡿⢿⣿⡀⣉⣛⣛⣀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⣩⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣾⡷⢂⣾⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣦⣄⠁⠈⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠣⣰⣿⢿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⡴⢍⣙⠿⢻⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⠛⢦⣐⠲⢶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⢿⣿⣿⣿⣿⡿⣿⣿⠈⣿⡇⡇⣿⢣⢋⡴⢫⣾⡿⠃⣿⡿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣭⣥⠆⣾⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣄⢶⣬⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣝⠣⡙⢿⣿⣿⡇⢻⣿⣧⠻⡄⢣⢿⣠⣾⣿⣿⠟⠁⢘⡥⠀⣹⢟⡻⠝⣛⣿⣿⣿⣿⣿⣿⣿⡿⠟⡁⣾⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⡌⡛⠻⢿⣿⣿⣿⣿⣿⡿⠿⠿⠿⢿⣿⣒⣾⣿⣿⠗⣤⡿⠟⣡⣳⣾⣿⣿⡿⢿⣷⠶⠟⠫⠤⠾⠷⠿⣾⣿⣿⣿⣿⣿⡿⢡⣿⣿⣷⣦⠤⢠⠟⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣉⣒⠶⣶⣾⣿⡌⢏⠻⡿⢰⣾⣿⣿⣿⣿⣿⣿⣿⠃⢞⡅⡀⡾⡉⣉⠛⣁⡈⠙⠐⠈⠆⢲⣿⣿⣿⣿⣷⣶⣶⣶⣮⢻⣟⣡⢃⣿⣿⣷⣦⣤⡵⢢⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣟⠉⣛⣁⣠⣿⣿⣿⣦⣑⡆⣼⣿⣿⡿⢸⣿⣿⣿⣏⣠⣏⣼⠁⡄⣴⣿⣿⣿⣿⡐⡄⣧⣀⢸⣿⣿⣿⣿⣿⡹⣿⣿⣿⢸⣿⣷⣿⣿⣿⣿⡿⠟⣱⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⢆⠙⠿⣿⣿⡄⠻⢿⣿⡇⣿⣿⣿⠃⣾⣿⣿⣿⣿⣿⣿⡇⢾⣷⢟⣭⣶⣮⡙⢿⡿⢿⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⣿⠀⣿⣿⠟⣼⣿⣿⣶⠎⢠⣾⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣧⠀⠩⣥⣴⢿⣿⡌⢦⣬⡅⣿⣿⣯⢠⣿⣿⣿⣿⣿⣿⣿⡇⣦⣵⣿⣿⣿⣿⣿⣷⣞⠀⢸⣿⡇⢻⣿⣿⣿⡇⠊⣿⣿⢸⣿⣋⡜⣴⣿⣿⣿⠟⣢⣽⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⠄⠒⠍⠀⣈⡛⢦⣝⡇⣿⣿⡁⣸⣿⣿⣿⣿⣿⣿⡟⡐⠸⣿⣿⣿⣿⣿⣿⣿⠇⣀⢸⣿⣿⢸⣿⣿⣿⣗⠀⣿⣿⢸⠟⣿⡾⢟⢹⡿⠅⣠⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣶⣉⠻⣿⣿⣿⣷⣌⠃⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⣷⡀⢘⢿⣿⣿⣿⡿⢋⢞⣼⡾⣿⣿⡌⣿⣿⣿⣯⣬⣿⡏⠎⣂⣩⣶⣁⣭⣀⠬⣉⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⣠⣍⠻⡏⣿⢩⣐⣾⠟⣋⣭⣶⣎⢻⣿⣿⣿⣷⡹⣷⡈⡌⣿⣿⣿⢡⢫⣾⢟⣼⣿⣿⡇⠟⣩⣍⣙⡻⢿⡇⢀⠛⣿⣿⢟⣉⠁⣼⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⡏⡙⢷⡄⠰⢸⡁⢻⡟⠟⠿⣿⣿⣤⡙⢿⣿⣿⣿⣮⣃⣯⠙⣿⣃⣇⣛⣵⣿⣿⣿⡿⠃⢸⣿⣿⣿⣿⣿⠏⣿⠠⠁⣡⡟⢩⠃⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢧⠁⢆⠻⢸⠀⣷⡀⣷⡠⣤⣄⡈⠁⠙⠂⠙⠿⣿⣿⣿⡟⡸⣿⢿⢿⣿⣿⣿⠿⢋⡔⣸⢸⣿⣿⣿⣿⠋⢀⡿⣴⠃⠏⠀⢠⢀⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡿⠛⣫⠤⠘⠃⠆⠀⠐⠀⣿⣿⣿⣷⣌⡻⢿⣤⣦⣶⣶⠄⠀⣬⡉⠀⢁⣿⡈⠠⠙⠋⣡⠔⠛⠹⠏⠘⣛⠍⢚⣿⣷⣿⡇⠿⢸⠀⠛⡸⣠⣭⣛⠻⢿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⡿⠟⣋⣥⣶⣿⡏⣾⠁⠀⠀⠡⠂⣓⢻⣿⣿⣿⣿⣿⣿⡶⢶⣒⡤⠚⣩⣦⠐⢄⠘⣿⠁⡀⢀⡹⠶⠐⡢⢤⡄⣤⣴⣾⣿⣿⣿⣿⠀⡀⠃⣚⠀⢃⣿⣿⣿⣿⣷⣬⣙⠛⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠟⣫⣵⣾⣿⣿⣿⣿⠀⣿⠀⠀⠘⢷⣄⠸⠸⣿⣿⣿⣿⣿⣿⣿⣶⣶⡖⣾⣿⣿⣷⣾⡄⣿⢸⣥⣿⣿⣷⣶⣶⣾⢹⣿⣿⣿⣿⣿⣿⡟⣸⠃⠴⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⢰⣿⠀⡄⠀⣄⠙⠆⠃⢿⣿⣿⣿⣿⣿⣿⣿⠟⣼⣿⣿⣿⣿⣿⠇⢹⢸⣿⣿⣿⣿⣿⣿⣧⣼⣿⣿⣿⣿⣿⣿⠇⠉⠰⠀⠀⢰⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⠀⡇⠀⣿⣷⣤⠰⢸⣿⣿⣿⣿⣿⣿⣏⢾⣿⣿⣿⣿⣿⡛⠀⠨⠚⢻⣿⣿⣿⣿⣿⣿⣿⣿⣏⠉⢻⣿⡿⢠⠄⡆⡄⣀⢺⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⠀⡇⡇⣿⣿⣿⡄⠀⣿⣿⣿⣿⠟⣥⣥⣞⣛⣛⡛⢛⡿⠷⠼⠟⠀⣛⣛⣛⣻⣯⣭⣤⡄⡜⢻⣧⣾⣿⡧⠀⢰⠇⡇⣿⢸⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠛⠛⠛⠛⠛⠛⠛⣼⣿⡀⠋⣤⠉⠭⣭⣉⣈⡉⠭⠉⣉⡈⠛⠃⠻⣿⣿⣷⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠏⠃⠋⠀⠉⠩⣍⠁⠀⠉⠀⣉⡉⢬⣈⠉⡉⠉⠉⡉⠩⢉⠉⠩⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⣀⢀⣿⣿⡇⣸⡏⢘⡡⠴⢛⡳⠤⣙⡻⠿⠋⡀⠀⠐⡒⠤⣉⠀⠉⠉⠉⡉⠉⢍⣉⠉⠥⠒⠤⠞⠀⣐⡻⢟⡛⠀⠹⠦⠌⣛⣟⣛⠁⣀⡟⠤⢙⠿⠟⡛⠀⠸⡓⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿⠁⣛⡃⢛⣒⣓⠒⠛⣓⣿⣋⣚⣻⡗⢂⡘⠛⣶⣾⣿⣿⡶⠿⣷⣿⣶⣾⣿⡷⠶⠆⠸⠷⠾⠿⠿⠷⠶⢦⣾⣷⣒⡛⠟⣿⠿⣷⣷⣶⣿⣷⣶⡾⠿⢷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⡿⢩⣯⡀⣭⣭⠀⡉⢁⣙⣛⣛⣃⣓⣛⣛⣛⡛⢛⠁⠈⢃⣘⣛⣛⣛⣛⣓⣒⣛⣛⣙⣛⣛⣓⣘⠋⣉⠉⠉⣉⣉⡉⠉⠉⣉⣉⣉⣁⣈⣉⣉⣉⣉⣉⣉⣉⣉⣁⣤⣭⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⡟⣵⣿⣿⡇⣿⣿⢀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠑⣄⠁⠍⡻⣿⣷⣶⣶⣦⣤⣤⣶⣶⠾⣛⣵⠟⡡⢠⣾⣿⡫⠀⠀⢣⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣋⣼⣿⣿⣿⡇⣿⣿⢸⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠘⣷⡄⠀⠑⠐⠒⠒⠛⠒⠒⠒⠚⡛⡉⠀⣨⣼⣿⣿⡷⠀⠀⢠⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                Ou preferes o Zoro, o espadachim implacável que corta os inimigos com precisão mortal?
                
                """ + Tools.color.RESET);

        Tools.pausar();

        System.out.print(Tools.color.BLUE + """
                
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠡⣫⡶⣾⣟⣶⣿⢿⣿⣿⣿⣽⣿⣿⣿⣿⣿⣿⣿⣟⡷⣯⡿⣟⡻⣯⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⢏⠲⡁⢎⣹⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢋⣾⣿⡿⣿⣿⡿⣵⣿⣿⣟⣾⣿⢫⣾⣿⣿⡟⡝⡿⣿⣽⣿⣿⣿⣝⣯⣻⣮⣻⣿⣿⣿⣿⣿⣿⣿⠊⠤⠑⢠⢚⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣣⣿⣿⢟⣾⣿⡿⣼⣿⣟⡿⣿⠏⣡⣿⣿⣿⢿⡇⡀⣈⢻⡻⡿⣟⢿⡻⣯⣿⣾⢷⡽⣿⣿⣿⣿⣿⣿⠈⠄⠃⠄⣚⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠿⡿⢿⢿⡿⣿⢿⣿⡿⣿⢿⣿⢷⣿⣽⣯⣾⣳⡿⣽⣿⣟⣾⢳⡿⣰⣿⣿⢻⣿⣿⡧⣰⣟⢧⡙⠽⣟⣿⢿⡿⣿⣝⣿⣻⣮⢿⠿⡿⠿⢏⠐⠈⡐⠠⠘⣿⡿⣿⠿⠿⠿⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⠑⡈⢂⠔⡠⢂⠔⠰⡀⢎⢠⣿⢣⡿⣽⣗⣿⢿⣿⣿⢽⡏⣿⣱⣿⣿⡏⣿⣿⣿⡇⣿⣿⣿⡳⡈⠿⣮⣷⣿⣽⣿⡽⣯⢿⡆⠒⢈⠐⡈⠄⡁⠄⠡⢁⡐⠐⠠⢊⠐⡁⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠐⠀⠂⠐⠠⠈⠐⠠⢈⣿⣏⣿⣹⡟⣼⣏⣿⣿⡏⣾⣏⡟⣿⣿⣿⣽⣿⢣⣿⠁⣸⣿⣿⣿⡽⡌⢽⡞⣏⣿⢿⣷⢻⡎⣿⠀⠂⠐⠀⠠⠀⠐⠀⠂⠀⠁⠂⠄⠂⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡄⣤⢠⡄⣤⣀⠐⠈⠀⢰⣿⣿⣿⡟⢶⣿⣼⣿⣿⢣⣿⣽⢸⣿⣿⡟⣿⡿⣸⢯⢀⣿⣿⣿⣿⣿⣼⡌⢿⣿⣼⡞⣿⡿⡇⢿⡇⠀⡄⡀⠀⠀⠀⠀⠠⡐⠤⠀⠀⠀⠀⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⢳⣎⠷⣫⠷⣭⢂⠀⠈⣾⣿⣿⣿⣧⣿⣿⣿⣿⣿⢸⣿⡟⣿⣿⡟⣼⡟⣅⡿⠃⣼⣿⣿⣿⣿⣿⣧⢃⠘⡏⢷⡗⣿⣷⣷⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⢀⢲⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢣⢎⠳⣍⢛⡜⣣⠖⡄⣿⣿⢸⣿⡿⣿⣿⣿⣿⣿⢼⣿⡇⣿⣿⢣⡿⡿⣸⡵⢈⣻⠷⢶⣻⣿⣿⣿⡧⠈⡇⣼⣿⣼⡏⣿⢸⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⡞⣬⠳⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠣⣌⠳⣈⠶⢬⡑⢮⠅⣿⡿⣿⣿⢧⢿⣿⣿⣿⣿⣾⣿⠃⣿⢇⣾⣹⢣⣯⠁⡗⣿⣛⣫⣾⡿⠟⠱⢿⡣⠗⣿⣼⢸⡗⡼⣽⢘⠰⢢⠀⠀⠀⠀⠀⠀⡘⠴⣉⢧⡱⢊⠵⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠣⡔⢣⡜⡌⢦⠙⢆⠳⠹⣧⢏⣿⡎⠾⣿⢸⣿⣿⣿⣯⢹⡟⣼⣳⣿⠟⡆⣼⣿⡻⠛⠟⣩⣌⠉⢩⣽⡆⠀⣿⡟⣽⡇⢭⡘⠨⠜⣁⠂⠀⠀⠀⠠⢠⡝⢮⡵⣎⠵⣋⠲⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⢣⡙⢣⠜⡘⡀⠉⠀⠁⠁⠙⣞⣜⣷⠀⢻⡎⣿⣿⢸⣿⢸⣹⡿⣿⡛⣸⠉⢿⣏⣴⣐⣧⣛⣿⣿⣿⣻⣷⠀⣿⢡⠳⡃⣾⠈⠁⠀⠀⠀⠀⢠⠘⢤⣃⠞⣧⣛⣬⣛⠼⣙⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢐⢢⡙⢦⡙⠤⡑⢂⠄⠀⡀⠀⠸⠰⡹⡿⡄⢷⣽⢹⣸⣿⢺⣿⣧⢻⡅⢻⢰⡼⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣘⡅⢀⡴⠈⠈⠀⠀⠀⠀⢠⠑⣢⠙⡦⣝⠺⡕⡞⢦⢫⡝⢬⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⢂⢍⠲⣌⡱⢜⡢⢎⡵⣢⠵⢀⡀⢹⡽⣝⣾⡞⣾⣇⢿⢸⣿⠏⢸⡇⡘⠸⡆⢿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣧⠀⠚⠑⠄⠀⠀⠀⠀⠀⠂⠱⠠⡙⢰⡉⢧⡹⠸⣥⢣⢞⡰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠎⢨⠑⢢⡑⢎⡱⢍⠶⡩⢷⡸⡄⡄⠙⢦⠻⣿⡎⢿⡸⠞⡟⠀⠜⣴⣳⡤⠃⢐⣟⣿⣿⢿⠿⠻⠛⢿⣿⡿⢁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠐⠘⠂⠕⠫⠔⠣⢎⢒⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢈⠰⢁⠘⠄⡘⠄⠒⡌⢒⠱⢢⠱⠉⠀⠀⠀⠂⠨⡙⢎⢳⠁⠃⣔⡾⣟⣿⠟⠗⢘⣋⣪⣤⣥⣶⠾⣋⣺⠿⠇⣎⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠂⡄⢊⠐⠠⠘⠠⠐⠡⢈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢀⣀⣿⣅⠴⢶⣚⣛⣻⣭⣿⣿⡶⢖⣯⣶⣯⠙⣃⢀⡃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠢⠐⡄⠈⠄⡁⠂⠁⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡦⡑⠻⣿⣷⣾⡭⣭⠭⠿⠶⠿⠟⣻⣿⡿⠃⠈⠸⢣⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢂⠡⢀⠃⠰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡵⣊⡈⠻⣿⣷⣧⠶⡀⠾⠑⠿⠻⠛⣠⠞⢠⣱⣧⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠂⠐⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢳⠄⠀⡶⣈⢋⠉⣀⢀⣀⢠⢤⡰⢞⣡⡞⢠⣿⡗⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢹⢃⠱⡍⢮⡝⢦⢫⡜⣣⢎⣳⣵⡿⢡⣿⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                Ou o Sanji, o cozinheiro galante que luta com os seus poderosos pontapés.
                
                A escolha é tua...
                
                """ + Tools.color.RESET);

        Tools.pausar();

        System.out.printf("""
                        
                            ______________________________
                          / \\                             \\
                         |   |         PERSONAGEM         |
                          \\_ |                            |
                             |     %s1- %sMonkey D. Luffy     |
                             |     %s2- %sRoronoa Zoro        |
                             |     %s3- %sVinsmoke Sanji      |
                             |   _________________________|_
                             \\_/___________________________/
                        
                        """,
                Tools.color.YELLOW, Tools.color.RESET,
                Tools.color.YELLOW, Tools.color.RESET,
                Tools.color.YELLOW, Tools.color.RESET);
    }

    public static void escolhaDificuldade() {
        System.out.printf("""
                        
                        Agora, escolhe a dificuldade do jogo, tua escolha afetará a tua experiência. Escolhe sabiamente!
                        
                            ______________________________
                          / \\                             \\
                         |   |         DIFICULDADE        |
                          \\_ |                            |
                             |         %s1- %sFácil           |
                             |         %s2- %sDifícil         |
                             |   _________________________|_
                             \\_/___________________________/
                        
                        """,
                Tools.color.YELLOW, Tools.color.RESET,
                Tools.color.YELLOW, Tools.color.RESET);
    }

    public static void escolhaPontos(int pontos, int pontosMin, int pontosForca, int pontosMax) {
        System.out.printf("""
                
                Agora é hora de distribuir os teus pontos de criação!
                
                Pontos de criação = %s pts
                
                Lembra-te:
                - Cada ponto de vida  custa 1 ponto de criação.
                - Cada ponto de força 💪 custa 5 pontos de criação.
                
                """, pontos);

        Tools.pausar();

        System.out.printf("""
                        
                        Ao distribuir pontos de força 💪, lembra-te dos seguintes limites:
                        - Força mínima: %s (equivale a %s pontos de criação).
                        - Força máxima: %s (equivale a %s pontos de criação).
                        
                        Escolhe com cuidado, pois a força afetará o teu desempenho em combate!
                        
                        """, (pontosMin / pontosForca),
                pontosMin,
                (pontosMax / pontosForca),
                pontosMax);
    }

    // *********************************************** INTRO PERSONAGENS ***********************************************

    public static void luffyIntro() {
        System.out.print(Tools.color.YELLOW + """
                
                Ei, tu! Escolheste-me? Boa decisão!
                
                Eu sou Luffy, o futuro Rei dos Piratas! Vamos derrotar o Kaido 🐉 e libertar Wano!🏯
                
                Não te preocupes, eu protejo-te!
                
                ⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠀⠰⢰⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠛⠛⠿⠿⠿⠿⣿
                ⠻⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠘⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣾⣿
                ⠀⠈⠙⣿⣿⣿⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⡆⠀⠀⠀⠀⠀⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿
                ⠣⠄⠀⠈⢿⣿⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣷⠀⠀⠀⠀⠀⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿
                ⠀⠀⠀⠀⠈⢟⠛⣁⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣇⢸⡆⠀⠀⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣹
                ⠀⠀⠀⠀⠀⠘⣛⡛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣷⣬⣛⠿⣿⣿⣷⣿⡀⠀⣿⣿⣷⢀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿
                ⠀⠀⠀⠀⠀⠀⢹⠃⠀⠀⢀⡆⣤⢢⠀⠀⢰⠃⣼⣿⣿⣿⣿⣿⣷⣦⣿⣿⣿⣷⣤⣿⣿⣿⣼⡄⠀⠀⠀⠀⠀⠀⠀⢿⣿
                ⠀⠀⠀⠀⠀⠀⢀⣠⡄⠀⢸⣷⠶⠄⣁⢀⣿⣼⣿⠛⢉⣁⣀⠉⠻⣿⣿⣿⣿⣿⡿⣻⣍⣡⣶⡆⢠⡆⠀⠀⠀⢠⣀⣘⣿
                ⠀⠄⠀⠀⠀⠀⠀⢿⣅⠀⠀⢻⡘⠃⡿⢸⣿⣿⣿⣶⣾⣿⣿⣿⣶⣿⣿⣿⣿⣿⢰⣿⠿⠿⠿⣷⣿⡇⠀⠀⠀⢸⣿⣿⣿
                ⠊⠀⠀⠀⠀⠀⢀⠀⠹⠀⣀⠀⠑⢦⡀⢼⣿⡟⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢈⣿⣶⣶⣆⣸⣿⠁⠀⣤⡀⠈⣿⣿⣿
                ⠀⠀⠀⠀⠀⠀⢸⡄⠀⠹⡿⢀⣴⣦⡅⢸⣿⣿⠀⣶⣤⣬⣭⣛⣛⠿⠿⢿⣿⣵⣿⣶⣤⣬⣭⣭⠃⠀⣸⣿⣿⣷⣼⣿⣿
                ⠀⠀⠀⠀⠀⠀⠸⠀⠀⠀⢶⣿⣿⣿⣷⠀⢻⣿⣆⠙⠃⣛⣛⣻⠿⠿⣿⣷⣶⣶⣦⣍⡉⣹⣿⠃⣨⣾⣿⣿⣿⣿⣿⣿⣿
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⠀⠄⠙⢿⣦⣜⠻⣿⣿⣿⣿⣶⣦⣭⡉⠃⠋⠐⠛⠃⠲⠿⠿⠿⠿⣿⣿⣿⣿⣿
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣇⠀⠀⠀⠙⠿⣷⣬⣙⠻⠿⢿⣿⡿⠟⣀⣼⠟⣡⣾⣿⣿⣿⣶⣶⣿⣿⣿⣿⣿
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣇⠀⠀⠀⠀⠀⠈⠙⠻⢿⣿⣶⠶⠞⣛⣩⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                
                """ + Tools.color.RESET);

        Tools.pausar();

        System.out.print(Tools.color.WHITE_BRIGHT + """
                
                Luffy é o capitão destemido dos Chapéus de Palha, conhecido pela sua incrível força e pela sua vontade
                inabalável.
                
                Com o seu poder da Gomu Gomu no Mi, ele estica o corpo como borracha para esmagar os inimigos.
                
                Estás pronto para partir nesta aventura com ele?
                
                """ + Tools.color.RESET);

        Tools.pausar();
    }

    public static void zoroIntro() {
        System.out.print(Tools.color.GREEN + """
                
                Então escolheste-me? Bom, não te vou dececionar.
                
                Eu sou Zoro, o espadachim dos Chapéus de Palha ⚔️, e vou cortar todos os que se atravessarem no nosso caminho.
                
                Kaido 🐉 e Orochi não sabem com quem estão a lidar.
                
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⣀⣼⣇⠁⠘⠀⠄⠀⡼⣿⠿⢛⣉⢿⣷⣄⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠃⠶⣄⠻⠣⢉⣓⣡⣴⣤⣸⡐⠈⣦⣬⣀⠚⢛⣛⣦⠄⠈⣛⡛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢋⣐⣛⡾⠁⣰⣰⣿⣿⣿⣿⡿⣿⣿⣤⣧⠹⡏⠑⢄⠘⢿⣶⣆⠨⡙⢦⠘⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣭⣀⠛⣿⡟⢡⣾⣿⣿⣿⣍⢉⣿⡗⢸⣿⣿⣿⡇⠙⠳⡄⠧⠀⡙⣿⣦⡘⢆⢁⢻⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⠰⡿⢠⣸⡿⢋⣉⡛⠿⣶⠅⡀⠸⠙⠛⠉⠥⠸⠷⣦⣈⣄⠱⢌⠻⢋⠀⠈⣸⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⠀⣸⠀⢈⣿⠴⢋⠉⠐⡂⢀⠀⠀⣴⣾⣧⣀⣉⡈⣭⣼⣿⣿⠀⠂⢀⠀⢠⣶⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡌⢻⡇⢸⣧⣄⡐⣂⣀⣴⣿⣿⡀⠈⣿⣿⣿⣿⡇⢹⣿⣿⣿⡆⠀⠛⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⠀⣁⠈⣿⣿⣿⣿⣿⣿⣿⣿⡟⢚⠻⣿⣿⣿⣧⣼⣿⠟⠋⠄⠀⠀⢁⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣷⣦⡙⠇⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⡾⠿⠛⠛⠻⣿⣿⣦⡑⠄⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⣀⣀⣀⡉⠍⠐⠈⠻⠿⣿⣿⡿⠛⣩⠴⠖⡒⠚⠉⢉⣁⡈⢻⣿⠛⠆⠀⠀⠠⡙⢿⣿⣿⡿⠟⠋⠀⣠⠄
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⣶⣤⣄⡉⢀⡡⠔⣨⡴⠶⠛⠉⠻⢿⣿⣿⣿⠄⠀⡆⡀⠢⠀⠞⠋⢁⣤⡠⠔⠉⠀⠀
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡘⢿⣿⣅⣠⣴⣿⣡⣴⣴⣾⣿⣿⣿⣿⡿⠋⠀⠰⣸⣐⣀⠁⠀⠤⠀⠠⣀⣀⠤⠒⠛
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠙⠻⢿⣿⣿⣿⣿⣿⣿⡿⠟⠛⠉⠀⢰⠠⣀⢸⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠈⠉⢉⢉⠁⠀⡄⠆⠡⠰⠀⠈⡆⡟⣸⡏⠀⠀⠀⢠⠀⠀⠀⠀⠀⠀⠀
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠋⠁⠀⣴⡶⠚⠉⠀⠀⠀⠀⠉⠠⢻⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⣰⢃⣿⢸⣷⠀⠀⠀⠀⠀⠀
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⣤⠀⠀⢿⡿⣿⣿⣿⣿⣿⡿⠛⠉⠀⣀⣠⠿⠊⠁⠀⠀⣀⣴⠞⡈⠀⢸⣤⣿⣿⣿⣿⣿⣿⡿⠁⠀⠀⠀⣸⣿⢸⡏⢸⣿⣆⠀⠀⠀⠀⠀
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡁⢾⡿⠆⠀⠈⠀⢸⣿⠟⠋⠁⠀⣠⡤⠞⠉⠀⠀⢀⣠⣴⣿⡿⠁⠘⠀⠀⢸⡟⢿⣿⣿⣿⣿⡿⠁⠀⠀⠀⢠⣿⡇⣿⡇⢸⣿⣿⡄⠀⠀⠀⠀
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡷⢀⡄⠀⠀⠀⠀⠀⠀⣀⣀⠶⠒⠁⠀⠀⢀⣠⣴⣿⣿⣿⠟⠀⠀⠂⠀⢠⢸⣿⣿⣿⣿⠟⣡⡄⠀⠀⠀⢀⣾⡿⢡⣿⡇⡼⣿⣿⣿⣆⠀⠀⠀
                ⣿⣿⣿⣿⣿⣿⣿⠟⣉⣭⣍⣙⠃⠟⣓⠀⠀⠀⢷⡀⠐⠋⠁⠀⠀⢀⣤⣶⣿⣿⣿⡿⠟⠋⠀⠀⠀⠀⠀⣼⣆⣿⣿⡿⣣⣾⡟⠀⠀⠀⠀⣸⣿⣇⣠⣿⡇⠠⢾⣿⣿⣿⣧⠀⠀
                ⣿⣿⣿⣿⠿⠛⠋⢠⣿⣿⡄⠏⠓⠀⣠⡄⠀⠀⠈⣷⡀⠀⢀⣤⣾⣿⣿⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⣷⣌⠻⡏⣰⣿⣿⠁⠀⠀⠀⣠⣿⣿⣿⣿⣿⣷⠀⢀⣿⣿⣿⣿⣷⣄
                ⣿⣿⠿⠉⢰⣿⡇⣼⣿⣿⠇⠀⠁⠀⠻⠿⠀⠀⠀⠈⠁⠀⢿⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠀⠀⣼⠀⠀⢀⣿⣿⣿⢡⣿⣿⡏⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣶⠾⠿⠿⠿⢿⣿⣿
                ⣩⡄⣾⠇⣿⣿⡇⠛⢉⣥⣴⣿⣶⣄⣑⠀⠒⡀⠀⠀⠀⠀⢀⣽⣿⣿⡟⠁⠀⠀⠀⠀⠀⢀⣾⡇⠀⠀⢸⣿⣿⡏⢚⣿⡟⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⡿⢋⣴⡈⠄⠠⢄⠈⢻
                
                """ + Tools.color.RESET);

        Tools.pausar();

        System.out.print(Tools.color.WHITE_BRIGHT + """
                
                Zoro é um mestre das três espadas, capaz de derrotar inimigos com uma precisão mortal.
                
                Com a sua técnica Santoryu, ele é uma força imparável no campo de batalha.
                
                Preparado para lutar ao seu lado?
                
                """ + Tools.color.RESET);
        Tools.pausar();
    }

    public static void sanjiIntro() {
        System.out.print(Tools.color.BLUE + """
                
                Ah, escolheste-me? Bem, não podias ter feito melhor.
                
                Eu sou Sanji 🚬, o cozinheiro dos Chapéus de Palha, e os meus pontapés vão mandar Kaido 🐉 e os seus capangas para o chão.
                
                E depois da batalha, preparo-te um banquete!
                
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢛⣩⣴⣶⣿⣿⡿⠟⣛⣿⡿⠿⣿⡿⣿⣯⣵⣦⣉⠻⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⡿⢋⣴⣿⣿⣿⡿⢋⣥⣶⡿⠋⠁⣀⣤⣶⣦⠸⣯⠻⣿⣿⣷⣌⠻⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⢋⣴⣿⣿⣿⡿⢋⣾⣿⡿⠁⣠⣴⣿⣿⣿⣿⣿⡇⣿⣇⢻⣿⣿⣿⣷⡘⢿⣿⣿⣿⣿
                ⣿⣿⣿⣿⡿⢃⣾⡿⢡⣿⡟⣱⣿⢃⠊⢀⠾⠿⠿⢿⣿⣿⣿⣿⡇⣿⣿⢸⡏⣿⣿⣿⣿⡌⢿⣿⣿⣿
                ⣿⣿⣿⡿⠁⢸⣿⢣⣿⡿⢰⣿⠃⠁⠀⠁⢰⠃⠉⣠⣿⣿⡿⠟⢡⣿⣿⣼⡇⡇⢿⣿⢹⣿⡌⢿⣿⣿
                ⣿⣿⣿⣤⡆⣿⡇⣼⣿⡇⣿⠏⠀⠸⣶⡦⠀⠁⠉⣉⣉⡀⠘⠿⢸⡿⢿⡏⡇⢿⡘⣿⡇⣿⣿⡈⣿⣿
                ⣿⣿⣿⣿⣷⢸⡇⣿⢿⠁⠋⠀⢀⣴⣿⣥⣦⣄⠰⠆⢰⣭⡅⠀⣿⢻⢿⡇⡇⠸⣧⢻⣷⠸⣿⣇⢹⣿
                ⣿⣿⣿⣿⡏⡸⠇⠏⡞⠀⡀⢴⣿⣿⣿⣿⣿⣿⣷⣶⣶⣶⣾⡇⠉⣾⢸⡇⢿⠀⣿⡎⣿⠀⣿⣿⢸⣿
                ⣿⣿⣿⡟⢀⠁⢀⠀⠀⣾⣿⡌⢏⣹⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⢸⡇⠈⡇⡌⠇⢹⡇⣿⢀⣿⡟⣸⣿
                ⣿⣿⣿⣷⣿⣧⠸⡄⠸⡿⠛⣋⣬⣛⠛⠿⣿⣿⡿⠛⠻⣿⡟⢠⡆⠇⢿⡄⠀⠀⠈⢧⡏⣈⣿⢁⣿⣿
                ⣿⣿⣿⣿⣿⣿⣇⠐⣾⣇⢠⣶⣶⣤⣍⡐⠊⠥⠞⣁⣤⣿⣷⣿⡇⠀⠸⠡⠨⠀⠼⡆⠙⣿⡿⢻⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⠀⣿⣿⣶⠆⢠⣍⠻⣿⣦⡄⢿⣿⣿⣿⣿⣿⣇⡀⠠⠶⢀⣤⠰⣧⡄⢸⠁⠒⢿⣿
                ⣿⣿⣿⣿⣿⣿⣿⡇⢿⢿⡟⠀⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⡴⠂⠛⠇⢀⣬⣅⣴⣶⣾⣶⣤
                ⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⠁⠀⠉⠛⠻⡿⠟⠛⠛⠛⠛⠛⣋⠉⣀⡂⣠⣤⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣄⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⡿⠟⠋⢰⣶⣶⣶⣦⣿⡀⢿⣶⣤⡀⠀⠀⣠⣨⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⣿⡿⢿
                ⣿⡿⢋⡁⠛⣿⣶⣿⣿⣿⠿⣇⠇⠘⣿⣿⣿⣷⠈⢻⣿⣿⣿⣿⣿⡿⣿⠟⠁⠀⠀⠀⠁⠀⠀⠀⠤⣶
                
                """ + Tools.color.RESET);

        Tools.pausar();

        System.out.print(Tools.color.WHITE_BRIGHT + """
                
                Sanji é um lutador elegante e poderoso, especializado em artes marciais com os pés.
                
                Com o seu Diable Jambe, ele pode incendiar os inimigos com chamas intensas.
                
                Pronto para saborear a vitória com ele?
                
                """ + Tools.color.RESET);

        Tools.pausar();
    }


    // *********************************************** VENDEDOR ***********************************************
    public static void vendedorIntro() {
        System.out.print(Tools.color.WHITE + """
                
                ⣿⣟⣾⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⢁⡴⣿⣿⢹⣿⢿⣿⣿⣿⣿⣿⣿⠿⢿⣿⣿⣿⣧⢧⠀⠱⠘⢷⡄⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠂⠀⣠⢰⣿⡏⣸⡿⢘⣛⣘⣿⣿⣭⡭⠗⡊⣉⣮⡿⠿⠸⡆⠠⠐⠄⢣⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⠸⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⢀⠧⢸⣿⣣⣿⠃⣠⣤⣄⣀⡀⠒⣾⣽⢞⣩⣶⡿⣡⡄⡇⠀⠸⣆⠘⣄⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣷⢹⣿⣿⣿⣿⣿⣿⣿⠃⣸⠏⠐⠂⠀⠻⣫⡴⠆⠈⠻⠿⣿⣿⠴⠈⡃⠾⠟⣡⣬⣭⡁⡇⠰⡄⠄⠀⠁⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿
                ⣿⡎⣿⣿⣿⣿⣿⣿⡟⢠⡏⠀⠀⢠⡓⠰⠉⢄⣤⣤⡈⠀⠀⠀⠀⠉⡉⠀⢀⣒⣒⣂⡄⠃⠀⠻⢸⠸⠠⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿⣿
                ⣿⣷⢻⣿⣿⣿⣿⣿⠃⣼⠃⣰⠀⢴⡖⣀⠐⣒⠂⠶⣂⣥⡶⣾⣾⣇⣃⣇⠳⣮⣭⣿⡿⢀⡜⠇⠸⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿
                ⣿⣿⢸⣿⣿⣿⣿⢃⢠⣿⠀⠋⠇⢠⣾⣿⣦⣙⠗⠸⠿⣛⣴⣿⣿⣿⣿⢹⣷⣮⣭⣭⡇⢸⣿⡀⠀⢀⢰⡸⣿⣿⣿⣿⣿⣿⣿⡇⢿⣿
                ⣿⣿⢸⣿⣿⣿⣿⠜⢸⣿⠘⢠⠠⡀⣿⣿⣿⣿⡇⠘⣻⣿⣿⣿⠟⡛⠛⠩⠿⠿⠏⢙⡃⠚⢹⡇⡄⠈⠈⣷⣍⣛⡛⢿⣿⣿⣿⠿⣸⣿
                ⣿⡿⣼⣿⢟⣫⣵⢖⣀⢻⡀⢳⠀⠣⠸⠟⠁⠀⠀⠨⠤⠠⠤⠵⣀⣐⣛⣲⣶⣿⣭⣭⣄⠀⢺⡅⠀⠁⡆⡌⠋⢭⡝⡆⠿⠿⠿⣦⣄⠹⣿
                ⣿⡇⡿⣡⣬⣙⠐⣻⣿⠀⠀⢧⡑⢄⢸⡅⠀⠰⣤⣿⣾⠿⠿⠛⠛⠛⠉⠉⠉⠙⠛⠻⠿⢀⠸⡇⢀⠘⢄⠑⢶⡄⢁⠰⢾⣷⣶⣦⡙⣿⣿
                ⣿⠄⠀⣽⣿⡏⢀⡿⢋⡄⣸⡇⠱⡀⠀⢷⣸⢰⡈⠉⠀⣠⣴⣶⣶⣿⣿⣷⣶⣶⣄⡀⢀⢿⡆⠀⢸⣷⠆⣸⡷⠂⣨⡙⠆⢙⣿⣿⣿⡆⣿
                ⠿⢠⣾⣿⣿⡇⣼⢁⢫⣾⠏⣪⡀⣧⠀⠈⠻⣿⡿⣄⠲⠿⢟⣛⣛⣻⣭⣭⣿⡯⠏⣡⢎⣾⡇⠀⠸⣇⢴⣄⡺⠐⠋⠀⢠⡀⣿⣿⣿⡇⣿
                """
                + Tools.color.GREEN_BRIGHT +
                """
                        
                        Oi, oi, oi! Parece que temos um aventureiro destemido por aqui!
                        
                        HA HA HA ...!
                        
                        """);

        Tools.pausar();

        System.out.print(Tools.color.GREEN_BRIGHT + """
                
                Eu sou Barry, o vendedor mais confiável de Wano!🏯 Tenho tudo o que precisas para sobreviver nesta terra perigosa.
                
                Armas, poções, consumível de combate...Se precisas, eu tenho! HA HA HA...!
                Mas cuidado, os melhores itens não são de graça. 🪙
                
                Estás a precisar de algo para a tua jornada? Tenho aqui algumas coisas que podem ser úteis...(S / N)
                
                """ + Tools.color.RESET);
    }

    public static void vendedorAparece() {
        System.out.print(Tools.color.WHITE + """
                
                ⣿⣟⣾⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⢁⡴⣿⣿⢹⣿⢿⣿⣿⣿⣿⣿⣿⠿⢿⣿⣿⣿⣧⢧⠀⠱⠘⢷⡄⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠂⠀⣠⢰⣿⡏⣸⡿⢘⣛⣘⣿⣿⣭⡭⠗⡊⣉⣮⡿⠿⠸⡆⠠⠐⠄⢣⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⠸⣿⣿⣿⣿⣿⣿⣿⣿⡿⠀⠀⢀⠧⢸⣿⣣⣿⠃⣠⣤⣄⣀⡀⠒⣾⣽⢞⣩⣶⡿⣡⡄⡇⠀⠸⣆⠘⣄⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣷⢹⣿⣿⣿⣿⣿⣿⣿⠃⣸⠏⠐⠂⠀⠻⣫⡴⠆⠈⠻⠿⣿⣿⠴⠈⡃⠾⠟⣡⣬⣭⡁⡇⠰⡄⠄⠀⠁⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿
                ⣿⡎⣿⣿⣿⣿⣿⣿⡟⢠⡏⠀⠀⢠⡓⠰⠉⢄⣤⣤⡈⠀⠀⠀⠀⠉⡉⠀⢀⣒⣒⣂⡄⠃⠀⠻⢸⠸⠠⣿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿⣿
                ⣿⣷⢻⣿⣿⣿⣿⣿⠃⣼⠃⣰⠀⢴⡖⣀⠐⣒⠂⠶⣂⣥⡶⣾⣾⣇⣃⣇⠳⣮⣭⣿⡿⢀⡜⠇⠸⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⢸⣿⣿
                ⣿⣿⢸⣿⣿⣿⣿⢃⢠⣿⠀⠋⠇⢠⣾⣿⣦⣙⠗⠸⠿⣛⣴⣿⣿⣿⣿⢹⣷⣮⣭⣭⡇⢸⣿⡀⠀⢀⢰⡸⣿⣿⣿⣿⣿⣿⣿⡇⢿⣿
                ⣿⣿⢸⣿⣿⣿⣿⠜⢸⣿⠘⢠⠠⡀⣿⣿⣿⣿⡇⠘⣻⣿⣿⣿⠟⡛⠛⠩⠿⠿⠏⢙⡃⠚⢹⡇⡄⠈⠈⣷⣍⣛⡛⢿⣿⣿⣿⠿⣸⣿
                ⣿⡿⣼⣿⢟⣫⣵⢖⣀⢻⡀⢳⠀⠣⠸⠟⠁⠀⠀⠨⠤⠠⠤⠵⣀⣐⣛⣲⣶⣿⣭⣭⣄⠀⢺⡅⠀⠁⡆⡌⠋⢭⡝⡆⠿⠿⠿⣦⣄⠹⣿
                ⣿⡇⡿⣡⣬⣙⠐⣻⣿⠀⠀⢧⡑⢄⢸⡅⠀⠰⣤⣿⣾⠿⠿⠛⠛⠛⠉⠉⠉⠙⠛⠻⠿⢀⠸⡇⢀⠘⢄⠑⢶⡄⢁⠰⢾⣷⣶⣦⡙⣿⣿
                ⣿⠄⠀⣽⣿⡏⢀⡿⢋⡄⣸⡇⠱⡀⠀⢷⣸⢰⡈⠉⠀⣠⣴⣶⣶⣿⣿⣷⣶⣶⣄⡀⢀⢿⡆⠀⢸⣷⠆⣸⡷⠂⣨⡙⠆⢙⣿⣿⣿⡆⣿
                ⠿⢠⣾⣿⣿⡇⣼⢁⢫⣾⠏⣪⡀⣧⠀⠈⠻⣿⡿⣄⠲⠿⢟⣛⣛⣻⣭⣭⣿⡯⠏⣡⢎⣾⡇⠀⠸⣇⢴⣄⡺⠐⠋⠀⢠⡀⣿⣿⣿⡇⣿
                """
                + Tools.color.GREEN_BRIGHT +
                """
                        
                        Ah, meu jovem aventureiro! Parece que o destino nos trouxe juntos novamente!
                        
                        HA HA HA ...!
                        
                        Estás a precisar de algo para a tua jornada? (S / N)
                        
                        """ + Tools.color.RESET);
    }

    public static void vendedorPergunta() {
        System.out.print(Tools.color.GREEN_BRIGHT + """
                
                Então, o que vais levar? Escolhe com sabedoria, aventureiro. 🏯 Wano não perdoa os despreparados.
                
                """);
    }

    public static void vendedorItemSim(Heroi heroi, ItemHeroi item) {
        System.out.printf(Tools.color.GREEN_BRIGHT + """
                        
                        Ah, excelente escolha, %s%s%s! "%s%s%s" vai servir-te bem nas tuas lutas.
                        
                        Lembra-te, uma boa ferramenta nas mãos certas pode mudar o rumo de uma batalha.
                        
                        """ + Tools.color.RESET,
                Tools.color.WHITE_BRIGHT, heroi.getNome(), Tools.color.GREEN_BRIGHT,
                Tools.color.WHITE_BRIGHT, item.getNome(), Tools.color.GREEN_BRIGHT);

    }

    public static void vendedorItemNao(Heroi heroi, ItemHeroi item) {
        System.out.printf(Tools.color.GREEN_BRIGHT + """
                        
                        Ei, %s%s%s! Estás mesmo a tentar comprar "%s%s%s"? HA HA HA ...!
                        
                        Parece que não tens as habilidades ou o treino necessário para o usar corretamente.
                        
                        Talvez haja outras coisas na loja que se adaptem melhor ao teu estilo.
                        
                        """ + Tools.color.RESET,
                Tools.color.WHITE_BRIGHT, heroi.getNome(), Tools.color.GREEN_BRIGHT,
                Tools.color.WHITE_BRIGHT, item.getNome(), Tools.color.GREEN_BRIGHT);

        Tools.pausar();
    }

    public static void vendedorPerguntaMais() {
        System.out.print(Tools.color.GREEN_BRIGHT + """
                
                Estás interessado em mais alguma coisa? Tenho aqui alguns tesouros que podem ser úteis na tua jornada. (S / N)
                
                """ + Tools.color.RESET);
    }

    public static void vendedorDespedida() {
        System.out.print(Tools.color.GREEN_BRIGHT + """
                
                HA HA HA HA ...! Nem sempre é fácil escolher o que precisamos.
                
                Mas lembra-te, se mudares de ideias, eu estarei por aqui, sempre com os melhores itens de Wano ⛩️.
                
                Boa sorte na tua jornada! E cuidado com os inimigos...
                
                """ + Tools.color.RESET);

        Tools.pausar();
    }

    // *********************************************** COMBATE ***********************************************

    public static void combateIntro(Heroi heroi, NPC npc) {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                                               ⚔️ %sPREPARE-SE PARA O COMBATE!%s ⚔️
                        
                        O teu oponente ergue-se à tua frente, determinação brilhando em seus olhos.
                        A atmosfera carrega-se com a energia do confronto iminente...
                        
                                                        %s%s VS %s%s
                        
                        """ + Tools.color.RESET,
                Tools.color.RED_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.RED_BOLD_BRIGHT,
                heroi.getNome(), npc.getNome(),
                Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void combateTurno(Entidade entidad) {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        ⚔️ %s%s ATACA!%s ⚔️
                        
                        """ + Tools.color.RESET,
                Tools.color.RED_BOLD_BRIGHT,
                entidad.getNome(),
                Tools.color.RED_BOLD_BRIGHT);

    }

    public static void combatePocao(Pocao pocao) {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        %s%s%s brilha nas tuas mãos enquanto a consumes.
                        Uma onda de energia percorre o teu corpo, curando as tuas feridas e fortalecendo os teus músculos! 💪✨
                        
                        %sVida recuperada:%s %s HP
                        %sForça aumentada:%s %s pontos de força (Apenas num turno)
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BRIGHT, pocao.getNome(), Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT, pocao.getVidaCurar(),
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT, pocao.getAumentoForca());
        Tools.pausar();
    }

    public static void combateConsumivelCombate(ConsumivelCombate combate) {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        %s%s%s brilha nas tuas mãos enquanto a atiras em direção ao inimigo!
                        Uma explosão ensurdecedora ilumina o campo de batalha, e o inimigo é atingido em cheio! 💥
                        
                        A fumaça dissipa-se, e o inimigo recua, claramente abalado pelo teu ataque fulminante! ⚡
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BRIGHT, combate.getNome(), Tools.color.WHITE_BRIGHT);
        Tools.pausar();
    }

    public static void combateGanhaHeroi(Heroi heroi) {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        🏴‍☠️  %s%s GANHOU%s  🏴‍☠️
                        
                        O inimigo cai ao chão, derrotado pela tua coragem e habilidade!
                        A batalha foi intensa, mas a tua determinação prevaleceu.
                        
                        A tua jornada continua! O destino de Wano depende de ti. 🎏
                        
                        """ + Tools.color.RESET,
                Tools.color.RED_BOLD_BRIGHT, heroi.getNome(), Tools.color.WHITE_BRIGHT);
    }

    public static void combateGanhaNPC(Heroi heroi) {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        💀  %s%s FOI DERROTADO%s  💀
                        
                        A tua jornada termina aqui.
                        
                        Mas lembra-te: mesmo na derrota, a tua luta inspirou os aldeões de Wano.
                        
                        Talvez, num outro tempo, outro herói surgirá para completar o que começaste. 🎏
                        
                        """ + Tools.color.RESET,
                Tools.color.RED_BOLD_BRIGHT, heroi.getNome(), Tools.color.WHITE_BRIGHT);
        Tools.pausar();
    }

    // *********************************************** VILA 1 ***********************************************


    public static void vilaKozukiIntro() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                              | |                     ⛩️  %sVILA KOZUKI%s  ⛩️                        | |
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);
    }

    public static void vilaKozuki() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        Chegaste à %sVila dos Kozuki%s 🏯, berço da lendária família que governou Wano com sabedoria por gerações.
                        As ruas que antes ecoavam com risadas e música, agora estão silenciosas sob as sombras do regime de Orochi 👺.
                        
                        🎎 Podes ver os rostos cansados dos aldeões, escondendo-se nas sombras enquanto os soldados marcham.
                        No ar, paira o cheiro de incenso dos templos e o aroma amargo da opressão.
                        
                        A tua primeira missão é ajudar os aldeãos a esconderem-se enquanto te infiltras na vila.
                        Cuidado com os soldados! Se te descobrirem, terás de lutar.
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void vilaKozukiAto1() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        🎏 %sAs ruas da Vila Kozuki abrem-se diante de ti como um leque%s 🎏
                        
                        %s1. Mercado Abandonado%s: Um velho vendedor, esconde-se entre as barracas destruídas.
                        Ele sussurra: "Tenho itens que podem salvar tua vida... se tiveres ouro suficiente 🪙"
                        
                        %s2. Bairro Residencial%s: Ouves gritos vindos de uma casa. Um aldeão está a ser ameaçado por
                        um soldado de Orochi 👺! Precisas de agir rápido.
                        
                        %s3. Templo Antigo%s: Uma construção em ruínas, onde se diz que os Kozuki esconderam um artefacto
                        capaz de enfraquecer Kaido...
                        
                        %s4. Mochila%s: A tua mochila contém as tuas poções...
                        
                        Escolhe o teu caminho com sabedoria...
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);
    }

    public static void vilaKozukiTemplo() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        Entras no 🏯 %sTemplo Antigo de Kozuki%s 🕯️, onde a luz do sol mal consegue penetrar.
                        O ar é pesado, e o silêncio é quebrado apenas pelo eco dos teus passos.
                        
                        Cuidado! Este lugar está cheio de armadilhas e mistérios.
                        
                        Podes encontrar um item lendário que te fará subir de nível...
                        Ou despertar algo que preferias ter deixado adormecido. 💀
                        
                        O que será que te espera?
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void vilaKozukiItemLendario() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                
                Encontras um item lendário!
                
                Entre as ruínas, brilha algo no chão... 🌟
                
                Este artefacto antigo emana uma energia poderosa, capaz de elevar o teu potencial ao próximo nível.
                
                """ + Tools.color.RESET);

        Tools.pausar();
    }

    // *********************************************** VILA 2 ***********************************************


    public static void vilaLamentosIntro() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                              | |                ⛩️  %sVILA DOS LAMENTOS%s  ⛩️                   | |
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);
    }

    public static void vilaLamentos() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                
                Esta vila, outrora um refúgio de paz e harmonia, agora é um lugar onde o desespero se agarra às 
                paredes como hera venenosa.
                
                🏯 As casas, antes vibrantes com cores e vida, estão agora cobertas de fuligem e decadência. 
                O vento uiva entre as ruínas, carregando consigo os lamentos daqueles que perderam tudo para a tirania de Orochi 🐲.
                
                🎎 Podes ver os aldeões, escondidos nas sombras, com olhos cheios de medo e resignação. 
                
                O cheiro de incenso queimado mistura-se com o odor de destruição, e o silêncio é quebrado apenas 
                pelos passos pesados dos soldados de Orochi, que patrulham as ruas com arrogância.
                
                """ + Tools.color.RESET);

        Tools.pausar();
    }

    public static void vilaLamentosAto1() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        🎏 As ruas da %sVila dos Lamentos%s continuam a revelar os seus segredos 🎏
                        
                        A vila está mais silenciosa agora, mas o perigo ainda espreita. Cada passo que dás pode levar-te a uma nova descoberta...
                        
                        %s1. Armazém dos Soldados%s: Um grupo de soldados de Orochi 👺 está a descarregar armas num armazém abandonado.
                        
                        %s2. Mercado Escondido%s: O velho vendedor reaparece, desta vez com itens ainda mais raros.
                        Ele sussurra: "Tenho algo especial para ti... mas o preço é alto. 🪙"
                        
                        %s3. Jardim dos Segredos%s: Um jardim abandonado, onde os samurais de Wano costumavam treinar.
                        Dizem que há algo escondido lá... mas também há rumores de uma armadilha mortal.
                        
                        %s4. Mochila%s: A tua mochila contém as tuas poções...
                        
                        Escolhe o teu caminho com sabedoria...
                        
                        """ + Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);
    }

    public static void vilaLamentosJardim() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        Ao entrares no ⛩️%sJardim dos Segredos%s⛩️, uma sensação de calma envolve-te.
                        
                        O ar está carregado com o perfume suave de flores desconhecidas, e o som de um riacho distante ecoa como uma 
                        melodia tranquila. Este lugar parece intocado pela tirania de Kaido 🐉, um refúgio escondido no meio do caos.
                        
                        Enquanto caminhas, notas pequenos detalhes: uma pedra com runas antigas, uma estátua de um samurai coberta 
                        de musgo, e um banco de madeira que parece convidar-te a descansar. Mas algo mais chama a tua atenção...
                        
                        Num canto do jardim, quase escondido entre as folhagens, brilha algo no chão. 
                        Será um tesouro esquecido... ou apenas um reflexo da luz?
                        
                        Ao te aproximares, descobres que é uma pequena bolsa de tecido, desgastada pelo tempo. 
                        Dentro dela, há 5 moedas de ouro! 🪙
                        
                        *"Um presente do jardim... ou talvez dos espíritos que aqui habitam."*
                        
                        O jardim parece agradecer-te por teres encontrado o seu segredo, e o vento sussurra uma bênção enquanto partes.
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void vilaLamentosJardimOuro() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        Ao te aproximares, descobres que é uma pequena bolsa de tecido, desgastada pelo tempo.
                        
                        Dentro dela, há %s5 moedas de ouro!%s 🪙
                        
                        "Um presente do jardim... ou talvez dos espíritos que aqui habitam."
                        
                        O jardim parece agradecer-te por teres encontrado o seu segredo, e o vento sussurra uma bênção enquanto partes.
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void vilaLamentosJardimNada() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        O jardim é tranquilo e belo, mas parece guardar os seus segredos com cuidado.
                        
                        Apesar de procurares, não encontras nada de valor... %spor agora.%s
                        
                        "Talvez num outro dia, o jardim revele os seus mistérios."
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }


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
