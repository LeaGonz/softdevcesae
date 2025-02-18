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

    // *********************************************** VILA 3 ***********************************************
    public static void vilaHakumaiIntro() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                              | |                   🌊  %sVILA HAKUMAI%s  🌊                     | |
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                        
                        """ + Tools.color.RESET,
                Tools.color.BLUE_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);
    }

    public static void vilaHakumai() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        Chegaste à %sVila Hakumai%s 🏮, a antiga capital portuária de Wano, onde outrora
                        os samurais e mercadores viajavam livremente sob o governo dos Kozuki. Agora,
                        as águas do porto estão escuras como a própria história deste lugar...
                        
                        ⚔️ As grandes muralhas da vila, antes símbolo de proteção, agora são
                        uma prisão. O porto está sob vigilância constante dos soldados de Orochi 👺,
                        e as bandeiras dos Piratas das Feras tremulam ao vento sombrio.
                        
                        O cheiro de pólvora 🔥 e metal queimado denuncia a presença de fábricas,
                        onde os aldeões são forçados a trabalhar sem descanso.  
                        
                        Cuidado! Se fores visto, serás caçado sem piedade pelos homens de Kaido.
                        É aqui que a resistência precisa da tua ajuda...  
                        
                        """ + Tools.color.RESET,
                Tools.color.BLUE_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void vilaHakumaiAto1() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        🌊 %sAs ruas estreitas de Hakumai estendem-se como um labirinto de histórias perdidas...%s 🌊
                        
                        Escolhe o teu próximo passo com cuidado:
                        
                        %s1. Doca Oculta%s: Um velho vendedor aproxima-se, com um olhar desconfiado.
                        "As correntes podem levar-te para dentro da fortaleza... mas uma vez lá dentro, não há volta."
                        
                        %s2. Bairro dos Ferreiros%s: Os gritos dos trabalhadores ecoam entre as chamas das forjas.
                        Dizem que um artesão ainda forja armas secretamente para a resistência... mas onde estará?
                        
                        %s3. Mansão de Orochi%s: A mansão da antiga capital está agora ocupada pelos oficiais inimigos.
                        Segredos ocultos podem estar trancados por trás dessas portas... mas vale o risco?
                        
                        %s4. Mochila%s: A tua mochila contém as tuas poções...
                        
                        Escolhe o teu caminho com sabedoria...
                        
                        """ + Tools.color.WHITE_BRIGHT,
                Tools.color.BLUE_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);
    }

    public static void vilaHakumaiMansao() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        %s🏯 MANSÃO DE OROCHI – O COVIL DA SERPENTE 🏯%s
                        
                        Passas pelos enormes portões da mansão, sentindo um arrepio na espinha.
                        
                        O lugar está envolto em um silêncio inquietante. As velas piscam nas paredes,
                        projetando sombras distorcidas dos dragões dourados esculpidos na madeira.
                        
                        👁️ Sabes que não deverias estar aqui...
                        
                        Mas também sabes que um verdadeiro pirata não teme a escuridão!
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void vilaHakumaiMansaoOuro() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        Ao empurrares a porta, uma luz dourada enche a sala.
                        
                        Paredes cobertas de moedas brilhantes, estátuas de jade e joias raras reluzem no escuro.
                        
                        "Ahahaha! Hoje é um dia de sorte!" pensas, enquanto enches os bolsos com %s10 moedas de ouro%s 🪙.
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void vilaHakumaiMansaoPocao() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        A pequena sala parece ter sido um antigo esconderijo de médicos da corte.
                        
                        Frascos de vidro brilham em meio à penumbra, e um deles chama tua atenção.
                        
                        "Isso parece útil..." pensas, ao guardar a %spoção de 50HP%s na tua mochila.
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    // *********************************************** VILA 4 ***********************************************

    public static void vilaAmigasaIntro() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                              | |                    ⛩️  %sVILA AMIGASA%s  ⛩️                    | |
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);
    }

    public static void vilaAmigasa() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        No passado, esta vila foi o lar de grandes guerreiros.
                        Hoje, não passa de um aglomerado de casas em ruínas, cercadas por campos secos e abandonados.
                        
                        🍂 O vento sopra entre os telhados quebrados, carregando consigo o eco das risadas de crianças que um dia correram por essas ruas... mas agora, só resta o silêncio.
                        
                        Os aldeões sobrevivem com migalhas, mal conseguindo se manter de pé.
                        Muitos foram forçados a trabalhar para Orochi e Kaido, enquanto os poucos que ficaram lutam diariamente contra a fome e a desesperança.
                        
                        🎎 No centro da vila, um pequeno grupo de sobreviventes ainda mantém a fé
                        na chegada de um salvador. %sMas será que é tarde demais?%s
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void vilaAmigasaAto1() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        🎏 %sA Vila Amigasa se estende diante de ti como um relicário de tempos esquecidos...%s 🎏
                        
                        Escolhe o teu próximo movimento com sabedoria:
                        
                        %s1. Antiga Casa do Daimyo%s: Uma casa maior que as outras, agora caída em ruínas.
                        Mas dizem que dentro dela ainda repousa um tesouro esquecido. Ou talvez... uma armadilha?
                        
                        %s2. Fonte Sagrada%s: Os mais velhos da vila murmuram sobre um poço antigo, onde dizem que 
                        a água ainda tem o poder de restaurar forças. Mas cuidado... há algo mais escondido por lá?
                        
                        %s3. Armazém Abandonado%s: Um velho vendedor, olha para ti com olhos determinados.
                        "Se ainda resta alguma honra em Wano... então precisamos de armas para lutar!"
                        
                        %s4. Mochila%s: A tua mochila contém as tuas poções...
                        
                        Escolhe o teu caminho com sabedoria...
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);
    }

    public static void vilaAmigasaFonte() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        Entras na 🏯 %sFonte Sagrada%s
                        
                        Segues por um caminho estreito de pedra, envolto pelo aroma de terra molhada 
                        e folhas de cerejeira secas.  
                        
                        💦 À tua frente, surge uma fonte antiga, esculpida em pedra pelo tempo.  
                        A água flui lentamente, refletindo a luz da lua num brilho prateado.  
                        
                        📜 Dizem que, em tempos antigos, os samurais de Wano vinham a este local  
                        para purificar as suas lâminas antes da batalha.  
                        
                        Mas agora, algo parece errado… o vento está parado, e o silêncio é perturbador.  
                        
                        Há algo… ou alguém à espreita nas sombras.  
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void vilaAmigasaItem() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        Com cautela, mergulhas a mão na água gelada.
                        
                        Algo metálico toca nos teus dedos... e quando puxas para fora, um brilho dourado ilumina a noite!
                        
                        🏴‍☠️ Recebeste uma %sBola de Canhão 💣%s
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    // *********************************************** VILA 5 ***********************************************

    public static void vilaRengokuIntro() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                              | |                    ⛩️  %sVILA RENGOKU%s  ⛩️                    | |
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);
    }

    public static void vilaRengoku() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        O vento sopra forte entre as ruínas.
                        
                        As casas de madeira, outrora imponentes, são agora esqueletos de um passado perdido.  
                        Este lugar já foi o lar de grandes guerreiros... mas agora, só restam cinzas e poeira.  
                        
                        🌫️ Há um estranho cheiro de incenso no ar. O silêncio é absoluto.  
                        Até mesmo os corvos que sobrevoam o céu evitam pousar aqui...  
                        
                        Dizem que os últimos samurais da vila lutaram até a morte contra os homens de Orochi,  
                        recusando-se a ajoelhar-se.  
                        
                        💀 Mas se todos caíram... %sentão quem são essas sombras que se movem ao longe?%s
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void vilaRengokuAto1() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        %s🏮 AS CHAMAS DO PASSADO AINDA ARDEM...%s 🏮
                        
                        Escolhe o teu caminho através das ruínas:
                        
                        %s1. Templo Destruído%s: No topo da colina, um templo de pedra resiste ao tempo.
                        Dizem que os últimos guerreiros deixaram uma relíquia ali... Mas algo espreita no escuro.
                        
                        %s2. Túmulos dos Samurais%s: Lápides cobertas de musgo enchem a colina.
                        Uma figura solitária ajoelha-se diante de uma delas... Mas será um amigo ou um inimigo?
                        
                        %s3. A Casa do Daimyo%s: A mansão principal da vila ainda está de pé.
                        Mas há pegadas recentes na poeira... Alguém ainda vive aqui? O vendedor?
                        
                        %s4. Mochila%s: A tua mochila contém as tuas poções...
                        
                        Escolhe o teu caminho com sabedoria...
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);
    }

    public static void vilaRengokuTumulos() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        %sSubes a colina de Rengoku%s, sentindo o vento frio cortar o silêncio da noite.
                        À tua frente, uma centena de lápides esquecidas espalham-se pelo vale.
                        
                        A névoa dança entre as pedras, como se os espíritos ainda vigiassem este lugar.
                        
                        Dizem que aqui jazem os últimos guerreiros do Clã Kozuki...
                        Homens que lutaram até o último suspiro contra a tirania de Orochi e Kaido 🐉.
                        
                        🏮 Uma fraca luz tremula mais à frente...
                        
                        Há alguém aqui... ou algo mais?
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void vilaRengokuItem() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        Encontras uma maçã dourada descansando sobre uma pedra.
                        
                        O brilho suave da fruta é hipnotizante, como se ela estivesse esperando por ti.
                        
                        🏴‍☠️ Dizem que esta maçã tem poderes misteriosos, capaz de curar qualquer ferimento
                        ou até conceder força a quem for digno de usá-la.
                        
                        🏴‍☠️ Recebeste a %s🍎 Maça Rengoku 💥%s
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    // *********************************************** KAIDO ***********************************************

    public static void kaidoChegada() {
        System.out.printf(Tools.color.YELLOW + """
                        
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⡾⢿⠏⠁⡠⠒⣉⣹⣾⣏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢇⠀⠀⢆⠀⠀⣇⠀⠀⢸⡏⡍⠀⢸⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠰⡿⠛⠁⣴⡅⢣⣾⣲⣿⡿⠿⡟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠇⢀⣨⣤⣶⣾⣾⣟⣿⣿⡇⣀⣼
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠇⠀⠀⢀⣼⣾⣷⠋⡟⢱⣰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡿⣿⠛⣿⠉⡟⠀⡏⠈⡇⠙⢻⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⠀⠊⢹⡞⣸⣘⠥⣻⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢣⡏⠀⡇⠀⡇⠀⢳⠀⢇⠀⣸⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠘⣍⠙⣏⣼⡍⠢⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣷⠀⢹⡀⢿⢀⣸⣆⣾⣽⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣄⢠⡠⠤⣄⣸⡀⠀⠀⠀⡸⣿⡯⣷⣯⡟⠦⡈⠲⣄⣠⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣼⣼⣧⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⣿⢿⢟⠟⢠⡴⠈⢿⡇⠀⠀⢰⢣⠻⡉⠉⢀⠇⠀⠌⠳⡄⢀⡽⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⠿⠿⣟⢷⣶⠏⡼⣲⣶⢸⣧⣄⢸⣷⣤⣌⣉⣙⣒⣋⠻⠥⢀⣀⡘⠀⢙⣶⣇⡀⣤⠤⠤⢤⡄⠤⣀⣀⣀⠀⠀⠀⠀⣿⣿⣟⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⡿⠟⢋⢰⣿⠇⠀⠸⣅⣼⠟⡿⡃⢀⣿⡿⢸⣿⣦⡟⢁⡀⢀⡸⡙⣿⣷⣶⠉⠻⠿⠿⢿⣰⠁⡎⠉⢢⠹⡀⠈⠻⣿⣷⡄⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⠂⠀⣾⠀⠀⠀⢰⣴⡿⢛⣾⣣⣿⡟⣻⡀⢋⣿⣿⡄⢻⡇⢸⡇⣀⣿⣿⡏⢀⣦⣤⣤⣤⣘⣦⣉⣁⡼⢠⣇⠀⣀⣧⣿⣿⡀⠀⣿⠏⢠⣏⣿⠛⢿⣿⣿
                        ⣿⣿⣿⣦⡤⠃⠀⠀⢠⣿⠀⢠⣾⣿⣿⣿⠷⡿⠇⣿⠿⢿⣿⣿⣇⢼⣿⢹⣿⡟⢀⣼⣿⣧⡿⣿⣿⣿⡄⢠⢶⣿⣿⡿⠿⠿⠿⠟⠧⢸⣿⣿⣿⣿⣿⣶⣿
                        ⣿⣿⣿⣿⣿⣦⡐⢠⡯⠼⣶⣿⣿⣿⣿⡏⠀⠀⣸⣿⣶⣦⣤⣍⣙⠛⠻⠿⠿⠀⡞⢻⣿⣿⣿⣿⣿⣿⣷⠘⡞⣿⣿⣿⣄⣠⣾⡧⠀⠤⡟⢓⠷⠽⣦⣭⣓⠿
                        ⣿⣿⣿⣿⣿⡟⠅⣠⡳⠀⣨⣿⣟⢻⣟⣔⡆⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⣼⡁⠸⣿⣿⣿⣭⣿⣿⣿⡄⢱⣘⣿⣿⣿⣯⣡⣿⠇⠀⡇⣸⠉⠓⣶⢸⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣾⠟⣹⡋⣿⡆⢹⠿⣄⠛⣣⣿⣿⣿⠁⣾⣿⣿⣿⣿⡟⠀⣼⣿⣷⣆⢻⣿⣿⣯⣾⣿⣿⣿⡄⠉⢽⣿⣿⣿⣿⢽⢴⡶⠁⣯⣶⡆⣿⡍⠙⢻
                        ⣿⣿⣿⣿⣿⡏⠀⣼⡿⠿⡾⣿⠀⢀⡼⣼⣿⣿⣿⣿⣿⣬⣽⣿⣿⠟⢀⣾⣿⣿⣿⣜⡌⢿⣿⣿⣿⣿⣻⢿⣿⣄⣠⢿⣾⣿⣿⣷⡊⠁⣼⣛⠿⢿⡇⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣧⣴⣿⣿⠓⣾⡧⡴⣏⣿⣿⣷⣌⡙⠻⣿⣿⣿⣿⠋⣠⣿⣿⣿⣿⣿⣿⣿⣆⠻⣿⣿⣮⣯⣾⣿⡿⠱⢿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣾⢹⣿⣇⣈
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣬⣤⣾⣿⣿⠛⠻⣿⣿⣷⣦⣭⠙⢁⣴⣿⣿⣧⡝⠿⣿⣿⣿⣿⣧⡙⠿⣿⣿⣿⣿⡇⠀⠚⣿⡏⠹⣿⣿⣾⣿⣿⡿⢣⣶⣤⣭⣍
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣷⣽⣿⣷⣤⡼⣿⡿⠛⠁⣠⠾⠿⣿⣿⣿⣿⣦⣈⠻⣿⣿⣿⣷⣄⡈⠙⠿⣿⡇⠀⢒⣿⡇⠀⣿⣿⣿⡿⠟⣡⣿⣾⣿⣯⣽
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⡛⢻⡛⠛⠉⢀⣤⠞⠙⡏⠙⠻⣿⣿⣿⣿⣿⣷⣌⡙⠿⣿⣿⣿⣷⣾⣿⣷⡂⢘⣿⡇⠀⣿⣿⣿⣴⣊⣉⣿⠟⣷⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠻⣗⢺⣿⣏⠀⠀⠀⠁⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣶⣤⣉⣿⣿⣿⣿⣿⣷⠛⣛⠛⣶⣿⣿⣃⣠⠴⠚⢁⣴⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠈⠳⠙⢿⣿⣄⠀⠀⠐⣲⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⡿⠯⢐⣦⣵⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠙⠻⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡷⣶⣖⣉⣹⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠈⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠟⠉⠁⠀⢈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠛⠛⠿⠿⣿⣿⣿⣿⣿⣿⣿⣯⣭⣤⣀⣀⠀⠀⠀⣰⣿⣿⠍⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        
                             %s🌊 MILHARES DE ONDAS SE ABREM DIANTE DO THOUSAND SUNNY! 🌊%s
                        
                        """ + Tools.color.WHITE_BRIGHT,
                Tools.color.WHITE_BRIGHT, Tools.color.WHITE_BRIGHT);
        Tools.pausar();

        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        O céu escurece sobre o oceano tempestuoso.
                        
                        Os relâmpagos cortam as nuvens, iluminando ao longe a silhueta sinistra de Onigashima.
                        
                        🏴‍☠️ A enorme caveira que coroa a ilha parece vigiar cada movimento do Sunny,
                        como se a própria terra estivesse viva, esperando pela batalha que se aproxima.
                        
                        %sLuffy avança até a proa%s, com um sorriso destemido no rosto.
                        
                        %s"É aqui que tudo termina... e onde tudo começa!"%s
                        
                        """, Tools.color.RED_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);
        Tools.pausar();

        System.out.printf(Tools.color.YELLOW + """
                
                ⣿⣿⣿⡿⢋⠔⣱⣦⠞⣡⠞⣩⡴⢚⣿⣿⣿⣿⣿⣿⣿⡿⠛⠁⠀⢠⠀⢀⣾⣿⣦⡀⠀⠀⠀⠀⠀⣦⡀⠀⠀⠀⠀⠀⠉⠻⢿⣿⣿⣿⣿⣿⣷⣬⣾⣿⡶⣍⠲⣌⠻⣿⣿⣿⣿⣿
                ⣿⣿⡟⡑⠡⣪⠏⡔⣻⣷⣾⢋⣴⣏⣽⣿⣿⣿⣿⡿⠋⠀⠀⠀⢠⣿⠀⢼⣿⣿⣿⣷⠄⠀⠀⠀⠀⠸⠿⣄⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿⡿⠿⢔⢪⡳⣜⢷⡜⢿⣿⣿⣿
                ⣿⡿⡁⠀⣰⢃⠊⣴⠟⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⣋⡅⢰⣿⣿⣿⣿⣿⣷⣄⠀⠀⠀⢸⣿⣶⣤⠀⠀⣆⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣷⣌⠢⡱⡑⡌⢦⡻⡎⠻⣿⣿
                ⣿⠡⠣⢰⠃⠂⣼⢃⡼⢋⣽⣿⣿⣿⣿⣿⡿⠃⠀⠀⠀⠀⠀⣴⣿⣧⣼⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⢸⣿⣿⣿⡧⠀⣈⠂⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣷⣷⣿⡿⣿⠷⡙⣂⢹⣿
                ⡃⡎⢲⣿⣼⣼⣇⡞⢠⣿⡟⢡⣿⣿⡿⠋⠀⠀⠀⠀⠀⠀⡸⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⢸⠟⠛⠭⡲⠇⢿⣷⡀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⡿⡏⢧⠱⡘⣧⢱⠘⣆⢻
                ⡇⡟⣸⢡⡏⣿⢹⡟⣿⡿⣷⣛⣛⣉⣀⡠⠀⠀⠀⠀⠄⢀⣿⠷⣒⣉⠉⠛⠛⠿⣿⣿⣿⣿⣯⢉⣅⡔⢠⣾⠉⠉⢱⣦⡙⣧⠀⢰⠀⠀⠀⠀⠀⠘⢿⣿⣧⠹⡜⡇⣷⢹⡆⠆⢹⣸
                ⡇⡇⣿⢸⡀⡏⢸⠇⡿⢰⣿⢿⡿⢿⣿⠃⠀⠀⠀⠀⣄⠘⣡⣾⠁⠀⣹⣆⢻⣿⣦⢹⣿⣿⣿⣬⣵⢠⣿⣿⣦⣤⣾⣿⣷⢸⡀⡈⡀⠀⠀⠀⠀⠠⣤⣽⣿⣧⣧⣷⣿⣾⣷⣼⢸⢿
                ⡇⡇⢻⠸⡇⣇⢸⡄⣷⢸⡇⣸⣧⣿⡏⠀⠀⠀⠀⢰⣿⢸⣿⣿⣷⣾⣿⣿⢸⣿⡏⠜⣿⣿⣿⣿⣿⣇⠿⣿⣿⣿⣿⣿⡟⣼⣧⣷⡇⠀⠀⠀⠀⠀⢿⡿⢻⠉⣿⢹⣿⡏⣿⢸⢸⢸
                ⣇⢀⢸⢦⣧⣼⣼⣷⣿⠾⣷⢺⣿⠙⠀⠀⠀⠀⠀⠘⣿⡘⣿⣿⣿⣿⡿⣫⢸⣿⣇⢲⣿⢿⣿⣿⣿⣿⠳⢮⢩⣭⡍⣥⠾⣻⣿⣿⡇⠀⡰⠂⠀⠀⠘⡇⡞⣸⡇⣼⡿⢱⠏⡞⠘⣸
                ⣿⡆⠘⡆⢏⢻⠙⣿⠹⣇⢻⠆⠁⠀⠀⢀⠀⢀⠀⢠⣿⣿⣦⣭⣭⣴⣾⣿⣷⣭⣭⣼⣿⣷⣿⣿⣿⣿⣿⣇⣶⣶⣶⣰⣿⣿⣿⣿⠁⡜⢰⣇⠀⠀⠀⠘⠷⣿⣾⡿⣷⣿⠞⡔⣱⣿
                ⡙⢿⡔⡘⡜⢆⠣⡘⣧⡙⣆⠻⣌⢿⡌⡿⠀⠈⢢⠈⣿⣿⣿⣿⣿⣿⡿⠿⠛⣛⣩⣭⣥⣴⣶⣶⣶⣶⣶⣯⣭⢹⣛⠻⠿⣿⣿⡇⢰⠇⠬⡘⠀⢸⢋⡼⠡⢡⡟⣡⢃⠎⠜⣰⣿⣿
                ⣫⣤⣍⠂⠈⢌⢢⣱⣬⣿⣿⣿⣿⠻⣿⠃⠀⠀⠂⢡⢹⣿⣿⢟⢫⣵⣶⣿⣿⣿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⢿⣸⣿⢀⡇⣿⣿⠃⣪⡞⣰⢃⣀⠀⢛⣴⣴⣋⣜⡁⣡⠎⣴⣿⣿⣿
                ⢿⣿⣿⣿⡦⠈⠻⢿⡟⢿⡝⢦⡻⣧⡑⢶⡖⢀⠀⠀⠄⢻⣿⠀⠊⢟⠋⠁⢀⣴⡾⢟⣛⣭⣭⣭⣛⡻⢿⣷⣄⠀⠀⠌⣸⣿⡏⢠⣵⢞⠁⢜⠙⣡⠞⣡⠟⡻⢋⠟⣡⣾⣿⣿⣿⣿
                ⡷⠹⠋⢁⣤⣶⣄⡂⢍⠢⡙⢦⡙⠦⣽⣾⣿⣿⠓⠀⠀⠄⢻⣧⡀⠉⠀⣴⠟⠡⠾⠿⢛⣛⣛⣛⣛⣛⣓⠮⠻⠷⢄⣴⣿⡟⠀⠉⠔⡻⢟⡱⢞⣡⠚⠁⣪⠔⣡⣾⣿⣿⣿⣿⣿⣿
                ⠂⠀⠀⠈⠻⣿⣿⣿⣦⡑⢬⣓⠬⣱⡾⣿⡿⢍⠓⢄⣒⠍⢂⠹⣿⣦⡈⢴⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢃⣵⣿⣿⠟⣠⠐⣧⡥⠖⡋⠔⡡⢋⡶⢛⣡⣾⣿⣿⣿⣿⣿⣿⣿⣿
                ⠀⠀⠀⠀⠀⠈⠻⣿⣿⣿⣶⣝⠳⣬⡓⠦⢍⡒⠬⢐⣂⣾⡿⢃⠌⠙⢿⣶⣮⣭⣛⣛⣛⣛⣛⣋⣭⣭⣶⣾⣿⡿⠛⢡⠞⡀⠄⡺⣯⣅⣂⠥⢒⣩⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⡀⠀⠀⠀⢄⠀⠀⠀⠙⢿⣿⣿⣷⣌⠻⣿⣶⣬⣕⣒⡲⠏⡈⠐⠨⠵⡆⠉⠛⠿⣿⣭⣭⣭⣭⣭⣥⣶⠿⠛⠁⢠⠸⢸⡗⠀⣑⠄⣐⣩⣴⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣄⠀⠀⠀⠙⠲⢤⣄⡀⠙⢿⣿⣿⣿⣮⡛⢿⣿⣿⣿⣷⣦⣅⣐⣒⠃⣷⡄⠇⡀⡍⡝⡛⡛⡉⠉⠀⠀⠁⠀⣼⢃⢈⣭⣥⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⢷⣄⠀⠀⠀⠀⠈⠛⢆⠀⠙⠿⣿⣿⣿⣦⡙⢿⣿⣿⣿⣿⣿⣿⡇⣿⣿⡆⡃⡇⠇⡇⡇⡇⠀⢸⢠⢠⢜⣵⣿⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                
                """ + Tools.color.WHITE_BRIGHT);
        Tools.pausar();

        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        💥 O navio corta as ondas, avançando como um rugido contra a tempestade!  
                        Chopper segura-se no mastro, enquanto Franky grita da cabine de controle.  
                        
                        %s"PREPAREM-SE! ESTAMOS CHEGANDO EM ONIGASHIMA!"%s  
                        
                        🏯 A enorme fortaleza de Kaido ergue-se ao longe,  
                        envolta em chamas e raios que iluminam o céu escuro.  
                        
                        Não há mais volta... %sA luta pelo destino de Wano começou!%s  
                        
                        """,
                Tools.color.RED_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);
        Tools.pausar();
    }

    public static void kaidoIntro() {
        System.out.printf(Tools.color.GREEN_BRIGHT + """
                        
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                              | |                      🐉  %sONIGASHIMA%s  🐉                        | |
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                        
                        """ + Tools.color.RESET,
                Tools.color.RED_BOLD_BRIGHT, Tools.color.GREEN_BRIGHT);
    }

    public static void kaidoOnigashima() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        Finalmente, após uma longa jornada, chegaste à temida ilha de %sOnigashima%s💀.
                        
                        No alto da montanha, a fortaleza de Kaido 🐉 ergue-se como um monstro de pedra,
                        com seu teto vermelho iluminado pelas chamas da guerra.
                        
                        Samurais, piratas e bestas gigantes lutam pelo destino de Wano. ⛩️
                        
                        🏴‍☠️ Os gritos de guerra ecoam pelas muralhas, enquanto os Piratas das Feras
                        defendem o território com ferocidade.
                        
                        Mas tu não vieste para lutar contra qualquer inimigo...
                        
                        O verdadeiro desafio espera no topo do castelo: 🐲 %sKaido, a Criatura Mais Forte!%s 🐲
                        
                        """ + Tools.color.RESET,
                Tools.color.YELLOW_BOLD_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.GREEN_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();

        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                                         Em Onigashima 💀, a batalha atinge o seu clímax!
                        
                        Para derrotar Kaido🐲 e libertar Wano, precisarás lutar com os três guerreiros mais fortes:
                        
                                                            🚬 %sSanji
                                                            ⚔️️ %sZoro
                                                            👒 %sLuffy
                        
                        %sOs valores do herói permanecerão os mesmos%s entre cada batalha.
                        
                        """ + Tools.color.WHITE_BRIGHT,
                Tools.color.BLUE_BRIGHT, Tools.color.GREEN_BRIGHT, Tools.color.YELLOW_BRIGHT, Tools.color.GREEN, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void kaidoSanji() {
        System.out.printf(Tools.color.BLUE + """
                        
                        ⠀⠀⡸⠁⠀⡸⠁⢠⠃⠀⠀⡸⠀⡸⠀⡎⠀⠀⠀⠇⢀⣿⠇⠈⠻⣿⣧⡀⠀⠀⠘⣄⠀⠁⠀⠀⠀⠘⡄⠀⠈⡆⠀⠀⠀⢳⡀⠀⠀⠀
                        ⠀⢠⠃⠀⢠⠃⢀⡇⠀⠀⢸⠇⢰⠁⡼⠀⠀⠀⡀⠀⣾⡿⠀⠀⠀⠈⠻⣿⣆⠀⠀⠀⠀⠀⢠⠀⠀⠀⠹⡀⠀⢱⠀⠀⡀⠆⢳⠀⠀⠀
                        ⠀⡜⠀⠀⡎⠀⢸⠀⠀⠀⢠⠀⡆⢠⠃⠀⠀⣰⠃⣼⣷⠇⠀⠀⠀⠀⠀⠘⢿⣧⠀⠀⠀⠀⠈⣧⠀⠀⠀⠃⠀⠈⡄⠀⢱⡈⢆⢣⠀⠀
                        ⠀⡇⠀⠀⠁⢸⠋⠀⠀⠀⡿⣤⠇⠘⠀⠀⣰⠇⢰⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠹⣧⠀⠀⠀⠀⢹⡆⠀⠀⢸⠀⠀⡇⠀⠀⣣⠈⢂⣳⡄
                        ⠀⠃⠀⠀⠀⢸⢰⠀⠀⠀⡇⣿⠀⡀⠀⢠⡏⢀⣿⣏⡠⣄⡀⠀⠀⠀⠀⠀⠀⡠⠺⡇⢰⡀⠀⢸⡿⠀⠀⠘⡇⠀⣳⢀⠀⠱⡳⡈⢫⡁
                        ⠀⢰⠀⡄⠀⢸⢸⠀⠀⠀⡇⢸⣠⠃⠀⣾⠃⣾⡿⠁⡀⠀⣵⠀⠀⠀⢀⣤⠊⠀⠀⢳⡀⣧⠀⠀⡇⠆⡆⢰⠃⠀⣿⡍⠱⠀⠙⢿⣄⠁
                        ⠀⠈⠀⡇⠀⢸⡸⡄⠀⠀⡇⠀⢹⠀⠀⣿⣰⣿⣧⠀⠧⠴⠃⠀⣠⣴⣋⣉⣭⣭⣭⣽⡇⣇⢡⠀⡇⠀⢣⢸⠀⠀⢿⣷⠀⡇⢠⠀⠉⠀
                        ⠀⠀⠀⣿⠀⢸⡇⢇⠀⠀⣧⠀⢸⡇⢸⣿⣿⠃⠙⢷⣤⣤⠖⣿⠟⠉⠀⠀⠉⢛⡡⠋⢻⣿⡄⢸⣧⡀⠘⡘⣆⠀⠸⣿⢷⣧⡀⡇⠀⠀
                        ⠀⠀⠰⠛⣆⠀⢿⠘⡄⠀⠹⡄⠘⢇⢠⣿⡏⠀⣠⡾⠛⠉⠉⠉⠒⠒⠀⠒⠒⠉⠀⠀⠘⢻⣧⣾⣿⣧⡀⠀⢻⣷⣦⣹⣸⠁⠀⡇⠀⡀
                        ⠀⠀⠀⠀⠘⢆⠈⢧⢹⣆⠀⢣⠀⠺⡌⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⢿⣇⠻⢦⣈⣿⡟⢹⠟⠀⡴⠁⡴⣡
                        ⠀⠀⠀⠀⠀⠈⢆⠊⢧⣻⠂⠈⢧⠠⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠟⠃⠀⢿⣿⠛⠉⢉⡷⠃⢀⡜⢁⠞⡴⣡
                        ⠀⠀⠀⠀⠀⠀⠈⣇⠐⣿⡀⠠⣎⣧⣻⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⢿⡿⠛⡇⢠⠞⠐⣡⣾⣵⠷
                        ⠀⠀⠀⠀⠀⠀⠀⢸⣶⣿⣧⢸⣿⣿⣿⣟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡏⠀⠀⢰⣿⠃⢠⠞⣩⠟⠁⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠛⠻⢻⣾⢿⣿⠀⠙⠛⠲⣄⠀⠀⠀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⠁⠀⠀⢈⣿⣤⠼⠋⠁⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠃⠀⠹⢦⠀⠀⠒⢋⣔⣊⡭⢥⣴⣶⣾⠿⣿⣷⡄⠀⠀⠀⠀⢀⣼⡿⠁⠀⢠⠿⠿⣿⡇⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢧⡀⠀⠈⣿⠋⡰⠛⠛⠉⠉⠉⠀⠀⠀⠀⠀⢀⣴⡿⠋⠀⣀⡴⠋⠀⠀⠈⢧⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣄⡴⢁⡜⠑⢿⡿⠛⠛⠀⠀⠀⠀⢀⣴⠿⠏⠀⢀⣼⠋⠀⠀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣶⡆⠀⠀⠀⣠⠞⢀⣎⣠⣤⣸⣿⣠⣷⣤⣾⣧⡶⠛⠁⠀⠀⣴⡟⠁⠀⠀⠀⠀⠀⠀⠀⢇⠀⠀⠀⠀⠀
                        ⣀⡀⠀⠀⠀⠀⣠⣴⣶⣿⣿⣿⡇⠀⠀⡴⠃⣠⠋⢹⣿⠿⠿⠿⠟⠛⠛⠉⠁⠀⠀⠀⢰⡾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡀⠀⠀⠀⠀
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠛⠀⠀⠸⣿⡶⡇⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢳⡀⢀⣀⡀
                        
                              %s🔥 SANJI VS. QUEEN – O ORGULHO DO BLACK LEG! 🔥%s
                        
                        """ + Tools.color.WHITE_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();

        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        O caos domina Onigashima 💀. Entre os gritos da batalha e as explosões,
                        Sanji avança pelas muralhas em chamas, buscando os inimigos mais poderosos.
                        
                        De repente, uma parede de aço cai diante dele, bloqueando o caminho.
                        
                              %s"Yohohoho! Não vais a lugar nenhum, pernas finas!"%s
                        
                        Um gigante de cabelos loiros e corpo cibernético emerge das sombras.
                        Com um sorriso sádico, ele ajusta suas armas mecânicas e encara Sanji.
                        
                        🏴‍☠️ É Queen, a Praga – o gênio da tecnologia, braço direito de Kaido!
                        
                        """ + Tools.color.WHITE_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.WHITE_BRIGHT);
        Tools.pausar();
    }

    public static void kaidoSanjiEscolha() {
        System.out.printf(Tools.color.BLUE_BRIGHT + """
                        
                        Escolhe o teu próximo passo:
                        
                        %s1. Lutar contra Queen%s – "Estou pronto! Vou acabar com esse palhaço!"
                        
                        %s2. Vendedor:%s "O destino de Wano está nas tuas mãos...
                        Mas até mesmo os mais fortes precisam de um pequeno empurrão, não?"
                        
                        %s3. Mochila%s: A tua mochila contém as tuas poções...
                        
                        """ + Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.BLUE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.BLUE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.BLUE_BRIGHT);
    }

    public static void kaidoZoro() {
        System.out.printf(Tools.color.GREEN + """
                        
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢻⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢃⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⠏⣰⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⡿⢁⣼⣿⣿⡇⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⡿⢁⣾⣿⣿⣿⡇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⢁⣾⣿⣿⣿⣿⣧⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⢇⣾⣿⣿⣿⣿⣿⣿⡀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⡏⣼⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⣿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⢱⣿⣿⣿⣿⣿⢘⢻⡏⣴⡀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⢡⣾⣷⣮⡻⢿⡿⢡⣾⣶⡙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⡏⣼⣿⣿⣿⣆⠈⡜⡇⣇⢻⣧⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠻⣿⡏⠻⣿⣦⣅⠈⡁⠈⢴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⡇⣿⣿⣿⣿⠏⣀⣡⣧⣉⣼⡏⡆⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢋⢰⣶⣬⢵⣥⣵⣿⣿⣿⣿⣾⡿⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⡇⣿⣿⣿⡟⣸⣿⣿⣿⣿⠟⣴⢿⡘⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠁⢾⣿⣿⡏⢸⠟⣸⣿⣿⣿⠿⢿⣷⡬⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⡷⣿⣿⣿⣇⠛⣩⡍⣿⡇⠼⠁⠉⠁⠹⣿⣿⣿⣿⣿⣿⣿⣿⡠⡌⡻⠦⠝⠃⢒⡘⠋⠙⣩⣍⠻⣿⣿⡗⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⡇⣿⣿⣿⣿⣿⠟⣡⣿⠁⠃⠃⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⢓⣶⡾⣿⣿⠻⣿⢻⡙⡇⢟⠅⠃⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⡇⢿⣿⣿⣿⡇⣾⣿⡏⡆⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⡟⢀⡇⣸⣿⣇⠛⡏⠀⣸⡆⢋⣤⡌⠀⠀⠛⠛⣋⣭⣤⣤⣬⣉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⠘⣿⣿⣿⣷⣬⣝⠸⣤⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣦⡌⠁⢣⠈⠙⠻⢲⡚⠛⢀⢉⣸⡇⢀⠠⣿⣶⣄⣉⣁⣀⣸⣿⣷⣌⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣇⠸⣿⣿⣷⡀⡋⢠⣿⡄⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣿⡇⠀⢳⣶⣶⠀⢷⣿⣿⡼⣿⠏⡄⢣⣌⣻⣿⣿⣿⠹⣿⣿⣿⣿⣧⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⡄⢻⣿⣿⣇⠫⠏⣍⢳⡀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⡿⣀⣤⡄⠻⣙⠓⠘⠉⣁⣴⠋⠀⣷⠈⣿⠃⠹⣿⡿⠀⣿⣿⣿⣿⣿⠆⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⡄⢻⣿⣿⣷⣿⢧⣘⠳⡀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⠟⣱⡿⠻⣏⢦⣌⠻⠤⠤⢚⣡⡂⠀⡟⡀⣿⠁⣐⢻⣿⣆⠘⢿⣿⠿⢋⢀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⡄⠻⣿⣿⣷⡄⠛⣡⣷⡀⠀⠀⠀⠀⠀⠀⠀⠘⢁⣼⣿⠋⢀⣿⢘⣿⣿⣧⣤⡈⣉⡛⢀⣼⡇⠋⣼⣏⠸⣿⣿⣇⢀⠠⣶⡏⣾⣇⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣄⢹⣿⣿⣇⢸⣿⣿⣿⣄⠀⠀⠀⠀⠀⠀⠀⠈⠻⣇⣰⣿⡿⣸⣿⣿⣿⣿⣷⡜⢿⣦⣿⡇⣼⣿⣷⢐⣿⣿⡟⠀⣿⣿⡀⣿⣿⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣦⡹⣿⣿⣌⡛⢛⣉⢻⣦⡀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⠇⠻⠿⠿⢿⣿⠿⠃⣘⣛⠻⢀⡿⣿⡏⢸⣿⣿⠁⠀⢿⣿⡇⢿⣿⣴⣱⡸⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣌⠻⣿⣿⣯⡉⢤⣿⢋⡄⠀⠀⠀⠀⠀⠀⠀⠀⠐⣆⣀⡂⠀⣀⣤⣶⣿⣿⣿⡿⣂⠰⣿⠇⣾⡿⠃⠠⢸⣦⡉⡉⢈⡛⢹⣿⣷⡸⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣌⠻⣿⣿⣶⣤⣾⡅⡟⡂⠀⠀⠀⠀⠀⠀⠀⠈⠻⠃⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠙⠀⡉⢠⢎⡿⠈⢹⣷⡘⢿⣿⣆⢻⣿⣧⢹⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⡶⠍⠻⢿⣷⣌⠻⢿⣿⣿⣄⠂⠩⠂⣦⣀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣿⡿⢃⠇⡾⢓⢠⠘⠁⠀⢰⡌⠻⣦⡙⢿⣇⢿⣿⡆⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣽⣏⡄⢲⡆⠀⢻⣿⣷⣤⡙⠻⣿⣶⣿⡦⣉⠻⠓⠠⡀⠀⠀⠀⠀⠀⠈⠻⡿⠿⣿⡿⠟⣡⠏⢠⣶⢃⠞⠀⠀⠀⢸⣷⡐⢨⢹⣦⠻⡎⢿⣧⢹⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣏⠀⠘⢧⡀⠄⠹⣿⣿⣿⣶⣌⠙⢿⣷⣦⣤⣼⣷⢸⡶⠄⠀⠀⠀⠀⠀⠀⠐⠉⠤⠬⠅⢐⢨⠄⠁⢠⠀⠀⠀⣠⠸⠁⡼⠀⣿⣷⡈⠜⣿⡌⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠙⡌⠂⠘⢿⣿⣿⠿⠀⢒⢌⡙⠻⣿⣿⣬⣥⣴⠀⢦⡀⠀⠀⠀⠀⠀⠀⠋⠼⠛⢀⡄⡷⠈⠀⢀⣴⠃⠀⢜⡴⠀⣿⣿⣷⡀⠡⢡⢹⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣟⠁⣉⠂⠀⠈⠀⠀⠀⠙⠏⠰⢃⠈⢷⠌⢷⣦⣉⠛⠿⣷⣴⡒⠦⢱⣤⠀⠀⠀⠀⠀⠀⠈⠛⠀⡇⢈⣠⠟⠁⡠⠔⡉⢀⢰⡘⣿⣿⠁⢀⣿⠂⠻⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣍⠳⣄⡀⠀⠀⠀⠠⠀⢠⠇⢰⣄⢻⡄⠀⢡⣾⣶⡤⠉⠛⠷⣬⣥⣶⠱⠦⠀⠀⠀⠀⠀⠀⠀⠻⢋⠔⣫⡴⠏⢀⡞⣸⡇⠙⢿⡐⣿⣟⢃⣠⠈⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣌⠛⢦⣄⠀⠀⢠⢸⢠⢸⢸⠘⣷⡀⢸⣿⣿⣿⠇⠀⣷⡀⢍⡛⠿⢿⣍⣘⣀⢠⡀⠀⠀⠀⠀⠈⠁⠀⠀⡄⠁⢿⡇⡀⢀⡁⠘⠀⠘⣡⣾⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⡍⠓⠂⣸⠈⣼⢸⡌⡆⠹⣷⡈⣿⣿⣿⣦⡈⣿⣷⠈⠛⠋⠐⠊⣉⣛⠲⠶⣄⣂⣀⠀⠀⠀⠀⠀⢰⣀⠀⠀⢁⠉⠀⣀⠻⣿⣿⣿⣿⣿
                        
                                          %s⚔️ ZORO VS. KING – O DUELO PELO CÉU! ⚔️%s
                        
                        """ + Tools.color.WHITE_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();

        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        Um guerreiro colossal, com asas negras 🪽 e uma máscara demoníaca 💀,
                        ergue sua espada flamejante.
                        
                        O fogo dança em torno dele, iluminando o símbolo dos Piratas das Feras gravado em sua armadura.
                        
                        👑 Este é King, o Selvagem – o guerreiro mais leal de Kaido,
                        descendente da extinta raça Lunarian, um monstro nascido para lutar.
                        
                        💬 %sKing:%s "Tu não tens chance, pirata. Meu corpo é invulnerável.
                        Os fracos queimam diante das chamas do céu."
                        
                        💬 %sZoro:%s "É? Eu só preciso de uma espada afiada o suficiente para te cortar."
                        
                        """ + Tools.color.WHITE_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.GREEN_BRIGHT, Tools.color.WHITE_BRIGHT);
        Tools.pausar();
    }

    public static void kaidoZoroEscolha() {
        System.out.printf(Tools.color.GREEN_BRIGHT + """
                        
                        Escolhe o teu próximo passo:
                        
                        %s1. Lutar contra King%s – "Estou pronto! Vou acabar com essa pomba!"
                        
                        %s2. Vendedor:%s "O destino de Wano está nas tuas mãos...
                        Mas até mesmo os mais fortes precisam de um pequeno empurrão, não?"
                        
                        %s3. Mochila%s: A tua mochila contém as tuas poções...
                        
                        """ + Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.GREEN_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.GREEN_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.GREEN_BRIGHT);
    }

    public static void kaidoLuffy() {
        System.out.printf(Tools.color.YELLOW + """
                        
                        ⣿⣿⣿⣿⣿⠿⠟⣋⣥⣴⣾⣿⣿⣿⣿⣯⣽⣟⣛⣋⠛⣷⣶⣨⣥⣬⣙⡻⠟⠿⣿⣿⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣷⣿⣿⣿⣿⣿⣦⡙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⠟⣋⣩⣥⣾⣿⣿⣿⣿⣿⣿⣿⡿⢟⣿⣿⣿⣿⣿⠿⠟⠛⠿⢿⣿⣿⣿⣿⣷⣤⣻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣿⣆⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣽⣿⣿⣿⣿⣟⣋⠡⠾⠿⠟⠛⠉⠉⠰⠒⠒⠀⠐⠦⢄⠈⠉⠙⢿⣿⣿⣿⣶⣶⣍⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣾⣿⣦⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⡿⣿⣿⣟⣯⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣶⣶⣾⣳⣤⣈⠙⠹⠆⣀⠈⠛⠻⠿⠉⢈⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡝⣿⣻⣿⣿⡇⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⠛⠛⠛⠛⠛⠛⠛⠋⠈⡉⠛⠻⠿⣿⣶⡶⢠⣬⡀⠀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣟⣿⣻⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⣿⡀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⡿⣟⠋⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⢀⡤⢠⡄⡤⢆⣄⣀⣀⠀⠀⠉⠓⠀⠉⠁⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣼⣿⣝⣿⣿⣧⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⠿⠜⠉⠀⠀⠀⠀⠀⠀⠀⠀⣠⠔⠀⢀⠯⣞⠃⠘⢡⣛⡴⡳⣎⠟⠉⣀⣀⣤⣴⣾⣿⣩⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣯⣿⣿⣿⣏⣹⡏⢻⡏⢿⣿⣿⣇⡀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠣⠄⣴⠂⢬⠳⠌⢰⡉⢶⡙⠚⢁⣀⣴⣿⢿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⢻⣞⡿⡳⠯⠏⠙⠏⠛⠙⠋⠛⠉⠋⠛⠹⠛⠿⠨⣿⣿⣏⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⠀⠀⠀⠀⠀⠀⠐⠀⠀⠂⠀⠀⠀⠀⠀⢎⠡⠁⠤⢀⠃⣠⣿⡿⣿⣿⣿⣿⣿⡿⣿⠟⠛⠋⠋⠉⠁⠈⠁⠀⠀⠀⠀⡀⢀⠀⡀⢀⠀⡀⠄⠀⠄⢀⠀⡀⢀⠀⠈⠉⠛⠛⠄⠛⣛⣋⣭⣉⣡⣴⣶⣿⣿⣿⣿
                        ⠀⠀⠀⠰⠀⠈⠀⢀⠀⠀⠀⠀⠀⠀⠈⡀⠉⢀⠉⢀⣶⢸⣿⣶⡿⣿⠈⠇⠁⠀⠀⠀⠀⡀⢀⠀⠆⠰⠀⠆⠁⡈⠰⠀⠆⠰⠀⠆⠰⠀⠀⢀⠀⠀⠀⠀⠀⠆⠀⢀⣀⣀⣀⣶⣿⣿⣿⣿⣿⡿⣿⠿⣿⣿⢿
                        ⠠⢠⢁⠠⢀⠠⢈⣀⠠⠄⠚⠃⠂⡀⢐⠈⠀⠀⠀⣾⢿⠾⠏⠙⠀⠀⠀⠀⡀⠄⠂⠄⡁⠐⠠⢈⠠⠁⢂⠈⡐⢀⠀⠈⢀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣠⣤⣶⣾⣿⣿⡿⢚⣻⣿⡤⣄⣈⣡⡜⡻⠔⠋⠀⠀⠀
                        ⣉⣉⣈⣛⢓⣋⣉⣴⣾⣿⣿⣿⣧⢠⠈⠄⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠁⠀⡀⠄⢂⠠⠁⠂⠄⠐⠈⠀⠐⠀⠂⠈⢀⡠⠄⠲⢶⣶⣾⣿⣿⣿⣿⣿⣿⠿⠿⣿⣻⣟⡯⣟⠼⣓⠎⠲⠁⠈⠀⠀⠀⠀⠀⠀
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠂⠄⠁⢀⣀⣀⣀⣤⣤⣴⣶⣶⣶⣿⡍⠛⠙⣙⣶⣶⡏⠀⢐⣿⣿⣿⣿⠟⠁⠠⠂⢶⢮⡱⢋⠖⠉⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⣀⡤
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠟⠁⠀⠀⠀⠀⠀⠀⣀⣀⢀⣠⣤⣤⣴⣶⣿⣻⣿⣿⣿⣿⣿⣿⣿⠟⠛⢛⣁⣠⠡⠼⢿⣿⣷⡈⠡⠀⢼⡿⣟⡯⢧⡐⢎⡱⠂⠁⠀⠀⠀⠀⠀⠀⠀⠀⢀⡤⠴⣾⣿⣿⣿
                        ⣿⣿⣿⣿⡿⠿⠟⠋⡩⠅⠒⢀⠦⡝⠂⠂⢀⣤⣶⣿⠿⢿⣶⣾⣟⣯⣿⣿⣷⣾⣿⣿⣿⠿⣿⢿⣁⣤⣠⢿⡿⡟⠆⢀⣠⣝⣯⢷⠒⠉⢀⠤⡛⠜⠁⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⣿⣿⣿⣿⣿
                        ⣿⣿⠿⠶⢖⠨⢁⠂⠜⠀⠀⠀⢀⣠⣤⣾⡿⠟⠛⢳⡛⢿⠻⡽⣞⡟⠏⠙⢻⠶⣭⠶⣍⡻⢴⢫⡓⠧⢋⠯⠑⠠⢄⠋⠖⡩⠂⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠈⢣⠹⣿⣿⣿⣿
                        ⠀⠄⠈⠐⠀⠠⠀⠀⠀⠀⠀⠀⠈⠉⠉⠈⠉⠈⠁⠀⠈⠈⠁⠀⠀⠀⠀⠀⠈⠓⠈⠓⠈⠑⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡄⠀⠀⠀⠀⢀⣼⠓⠀⠆⠀⠀⠀⢠⠀⠀⢬⡆⢻⣿⣿⣿
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⢲⣶⣶⣶⣾⣿⣿⣿⣤⣤⡄⠀⠀⠀⣀⡴⣎⠀⠀⠀⠺⠁⠀⠀⠈⠀⠀⠀⠈⡄⠠⣶⣶⣿⣿⣿⣿
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠉⠷⠀⠀⢰⣤⣤⠀⢀⣀⣠⣶⣿⣏⠁⠀⠀⠀⠀⢹⣿⣿⣿⣵⡿⣾⣽⣻⢷⣿⣽⣦⢞⡱⣊⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡄⠀⠇⢈⣿⣿⣿⣿⣿⣿
                        ⣶⣶⣶⣶⣶⣶⡚⠁⠀⠀⠀⢄⡈⠁⠁⠀⡀⠀⠁⠀⠀⠀⠀⢠⣾⣿⣿⣧⣼⣿⡿⣿⢯⣮⠅⠀⠀⠀⠀⠘⢉⣩⣿⣿⣿⡷⣯⣿⣟⡾⣼⣝⡯⠅⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⢄⠃⢈⣁⣼⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠁⠂⢀⠀⠉⠀⠀⠀⠀⠀⠀⠀⢿⣿⣻⣿⣟⡿⣽⣳⣟⡼⣟⣶⣤⠀⢀⣴⣾⣿⣿⣯⣿⣽⣳⢿⣞⣟⣳⣞⣳⠢⢀⠀⠀⠀⠀⠀⡀⠀⠂⣰⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⡟⠐⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣆⠀⠀⠀⠸⣿⣿⣳⣿⢿⣹⡷⢯⣻⣭⣷⣾⣿⡿⠿⠿⠟⠛⠛⠛⠻⠿⢯⣿⣞⣳⣭⢇⠐⣀⠀⠀⠀⢠⠞⠀⠂⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠑⢦⠈⠻⣤⣀⠀⢻⣷⣿⣻⢿⣳⣟⣯⡷⡞⠇⠉⣀⣤⣤⣴⡶⣶⢾⣶⣶⣶⣤⣄⣈⠳⢟⡮⢃⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⡇⢠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠂⢈⠙⠡⠀⢻⡽⣯⡿⣿⣾⠗⢁⣤⣶⡿⡟⠯⠙⠃⠋⠐⠊⢙⣿⣗⣻⡿⣬⠖⡉⠂⠁⠀⠀⠀⠀⠃⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⡄⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠂⡂⠈⠱⢷⣫⢜⠷⣼⣿⣟⣻⣽⢧⣀⣀⣀⣀⣤⣾⣿⣿⡻⢯⣛⠬⠋⠀⠀⠀⠀⠀⡄⢠⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣧⣰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⣾⣟⣳⣾⣯⣟⣟⣿⣻⣿⢿⣿⢻⢿⡳⢏⠷⠌⠁⠀⠀⠀⠀⠀⢨⢁⣤⣤⣍⣉⣙⡉⠭⠽⠿⠿⠛⠛⠛⠋⠉⠉⠁⠀
                        ⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠿⣜⡿⣾⣽⢷⣯⢻⣼⣛⠧⡙⠌⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠑⠛⠎⠗⠫⠖⠉⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠿⠛⠛⠉⠉⠉⠉⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣞⣟⠆⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡧⣿⣎⠈⢳⢆⣄⡀⠀⠀⠀⠀⠀⠀⣀⣠⣴⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡇⣷⡻⣆⠈⢏⡾⣝⣛⡶⣖⣶⣶⡻⡿⣝⢏⣮⠀⠘⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢐⣏⡷⣻⡤⠄⠈⣽⣓⢮⣳⢽⡲⣭⣳⡟⡽⣚⡆⠀⢎⠰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⣧⢻⡵⢣⡏⠀⠐⣫⡝⡧⣏⢷⣋⡖⡷⣍⡙⠂⢰⡩⢎⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        
                                            %s🔥 👒 LUFFY VS KAIDO 🐉 – A BATALHA PELO AMANHECER! 🔥%s
                        
                        """ + Tools.color.WHITE_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();

        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        O céu de Onigashima 💀 está negro. Raios cortam as nuvens carregadas,
                        enquanto o castelo desmorona sob o peso da destruição.
                        
                        No topo, entre as ruínas em chamas, dois guerreiros se encaram.
                        
                        🐉 %sKaido, Imperador das Feras%s, ergue sua clava manchada de sangue,
                        seus olhos brilhando com um poder esmagador.
                        
                        🏴‍☠️ Diante dele, %sMonkey D. Luffy%s. Suas roupas estão rasgadas,
                        seu corpo coberto de feridas… mas o sorriso em seu rosto permanece.
                        
                        %sKaido:%s "Quantas vezes já te esmaguei?! Já chega! Foste longe demais!"
                        
                        %sLuffy:%s "Não importa quantas vezes me derrubes… EU SEMPRE ME LEVANTAREI!"
                        
                        Então… o último confronto começa!
                        
                                             🏴‍☠️ %sA Batalha Final Começa! 🏴‍☠️
                        
                        """ + Tools.color.WHITE_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.RED_BRIGHT);
        Tools.pausar();
    }

    public static void kaidoLuffyEscolha() {
        System.out.printf(Tools.color.YELLOW_BRIGHT + """
                        
                        Escolhe o teu próximo passo:
                        
                        %s1. Lutar contra Kaido 🐉%s – "Gomu Gomu no...!"
                        
                        %s2. Vendedor:%s "O destino de Wano está nas tuas mãos...
                        Mas até mesmo os mais fortes precisam de um pequeno empurrão, não?"
                        
                        %s3. Mochila%s: A tua mochila contém as tuas poções...
                        
                        """ + Tools.color.YELLOW_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.YELLOW_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.YELLOW_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.YELLOW_BRIGHT);
    }

    public static void kaidoLuffyG5() {
        Tools.limpar();
        System.out.printf(Tools.color.YELLOW_BRIGHT + """
                        
                        O corpo de Luffy começa a brilhar. Seu coração bate como os tambores da libertação…
                        
                                                      %sDoom! %sDoom! %sDoom!%s
                        
                                             Luffy: "Que loucura... estou todo branco!"
                        
                                                ☀️ %sGear 5 – O Deus do Sol Nika!%s ☀️
                        
                        O chão de Onigashima se dobra como borracha. Kaido ataca, mas Luffy agarra seu corpo gigante
                        e o gira como uma corda!
                        
                                             🏴‍☠️ %sAgora, a luta muda completamente!%s 🏴‍☠️
                        
                        """ + Tools.color.YELLOW_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.GREEN_BRIGHT, Tools.color.BLUE_BRIGHT, Tools.color.YELLOW_BRIGHT,
                Tools.color.WHITE_BRIGHT, Tools.color.YELLOW_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.YELLOW_BRIGHT);

        Tools.pausar();

        System.out.printf(Tools.color.WHITE_BRIGHT + """
                
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣟⢿⡇⢾⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡫⡄⢬⡁⡟⡖⣤⣆⠭⠛⣯⢰⣿⣿⠿⠿⢟⣛⣻⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠻⡿⣠⣴⡾⡿⣷⣶⣯⣤⢯⡾⢦⢹⣾⣿⣿⣿⣿⡿⠿⣿⣶⣽⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢟⡭⢏⠩⠖⠋⠯⢟⡿⢿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⣹⡠⢸⣯⢷⠟⠿⡿⣿⣗⣾⠡⢦⢸⠫⣿⣿⣟⢱⣾⡷⣻⣿⣯⣷⢿⣿⣿⣿⣿⣿⣿⣿⣿⣯⠟⢌⣶⣫⣟⣛⣙⡲⢮⡀⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡱⢸⣿⣻⡟⡩⣟⠫⠭⠥⠥⠈⢿⠖⣺⣿⠂⣻⣾⣿⢯⠿⢾⣿⣿⣿⢏⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢠⡿⣾⠽⢾⠳⠾⡴⢶⣿⡜
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⡿⣛⠻⣿⡷⢑⣻⣧⠾⠛⣡⣾⣞⣥⣖⢻⡎⣛⡟⣠⣵⣿⣿⡇⣷⣿⣇⣿⣿⣥⡟⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⣿⡇⣟⣻⣋⣟⣻⣙⣏⣽⡇
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣱⣷⡾⣿⣟⡛⠋⣉⢡⡀⠰⢪⡾⠋⠀⠀⠈⣽⠧⣬⢁⡾⣛⡻⢿⠿⢟⣯⣾⣿⣿⡿⣻⡿⠿⢿⣿⣿⣿⠿⢿⣿⣯⣿⣷⣯⣓⣛⣚⣓⣚⣾⣞⣇
                ⣿⣿⣿⣿⣿⣿⣿⣿⠟⢱⣿⣿⣪⠃⢻⡟⣣⣿⠛⣊⢔⣑⡿⣄⣀⣒⣩⡴⠃⣶⣶⣯⣾⢿⡛⢛⣛⣿⣿⣯⣿⣿⢎⣷⠟⡻⣷⣫⢰⣁⣾⣦⣿⡷⢹⣿⣸⣛⣝⣫⣛⣽⣹⢾⢸
                ⣿⣿⣿⣿⣿⣿⣿⣿⡘⡞⣿⣿⣷⣔⣠⡵⣛⣯⣿⢿⣷⢭⣤⣥⡍⠩⢇⣰⣧⠻⢳⡟⢵⡟⣿⣧⢻⣿⣿⣿⣿⡿⣸⣏⢧⢵⣻⣿⣿⢻⣿⣿⠟⢡⢸⣿⣧⣭⢭⠭⡭⠭⣭⡟⣾
                ⣿⣿⣿⣿⣿⣿⣿⣿⣷⣜⠟⢿⣿⣿⣿⣾⣭⣭⣭⣭⣍⢗⣮⠉⣥⣿⣾⣿⢛⣥⣺⣏⣧⠃⢿⣿⣷⡹⣿⣿⡿⣵⣿⠿⠿⠿⠟⣋⣡⣽⣿⣾⣶⣿⢸⣿⣟⣚⣚⣓⣛⣒⣛⢡⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⡿⣵⣾⣶⣽⣿⣿⣿⣿⣿⢿⢻⡿⢸⣿⣀⠐⠶⣂⡟⢋⡏⣆⠹⠮⣧⡀⢹⣿⣿⣼⠶⣿⣯⣵⠛⣋⣵⣾⣿⣿⣿⡟⢿⣷⢻⢸⣿⣿⣻⣝⣏⣟⣹⡏⢾⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⡷⣉⣔⡎⣿⣿⣿⣿⢪⣝⡦⠊⡴⣼⣿⣿⡟⡎⡝⢳⠸⣗⢧⠚⠷⠮⠭⠤⠄⠁⠼⢫⣾⡿⠣⣸⣿⣿⣿⣿⣿⣿⣧⣈⣛⠸⢸⣿⡿⢶⡻⣞⡾⢷⡍⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⡽⣿⣾⣯⣿⣿⣿⣿⡜⣿⣿⣧⢱⣿⣟⡛⣁⡇⠜⠋⠠⠁⡂⢙⡱⢿⠿⢟⣛⡛⢋⣼⣿⠅⠀⣿⣿⣿⣿⣿⡿⠟⢛⣛⡟⣥⡸⣿⣹⣣⣳⣍⣚⡿⣸⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⢻⣿⣋⣿⣿⣛⣵⡿⢻⣵⣾⣯⣿⡿⣩⣿⢠⠾⠧⠀⠁⠉⠔⠠⣬⣏⡟⢃⡜⣿⣿⡄⡀⢿⣿⣿⠟⡁⠈⠲⣛⣍⣇⢹⣷⣝⣧⠯⠤⣭⣙⣴⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢘⣋⣿⡿⡿⢊⣿⢏⣼⢠⣖⣯⣏⣠⣤⣾⠷⡬⡫⠋⢠⠋⣿⣿⣿⡆⠨⢛⡡⠂⠀⠀⠐⠿⠶⣽⢸⣿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⣿⢿⠝⣡⣶⡟⢯⣡⠗⠘⢟⣋⣭⡷⢶⣉⣶⡎⢁⢤⣶⡈⢺⣿⣿⣷⣆⠡⠃⠀⠀⠀⢠⢟⠓⡜⣤⣾⣿⣿⠸⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣛⣛⣟⣺⣿⣥⣤⣖⡙⡻⠞⢫⣴⣪⡾⢉⣐⢤⠬⢥⠭⣉⠯⣪⢛⣿⣧⡩⣿⢿⣿⣿⣶⣤⣤⣄⣒⣼⢛⠕⢐⣯⡝⢿⣽⣿⣿⣎⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢫⣜⣿⣿⠿⠿⣿⣿⣿⣿⣿⣷⣔⢖⡮⣤⣔⣩⡿⠜⡈⣶⣷⠟⡺⣱⣿⣿⣿⣷⣿⡿⣟⡿⢿⣿⣿⣟⣽⠽⣃⣾⣿⣿⣡⣿⣿⣿⢟⣾⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⢣⠶⢮⣻⣿⣿⢘⣿⠿⣰⠃⣙⣂⣄⡙⠍⢻⣿⣿⣧⡙⢦⡪⣭⣟⣻⠇⢿⡥⣮⣾⣿⣭⣛⣭⣥⣤⠼⡙⠛⡎⢋⣉⠡⣴⣾⣿⣟⣵⡫⣍⣿⣿⣵⣿⣿⣿⣿⣿⣿⣿
                ⣿⢟⠑⢋⡠⢤⣬⣄⡙⠛⣾⣇⠷⡇⣸⣿⣿⣿⣿⣦⢀⠻⣿⣿⡿⣶⣷⢩⡛⢫⢿⠞⣿⢏⣶⣿⣿⣿⠭⣟⢩⡙⢏⣩⣤⣬⣛⠆⠰⡝⣿⢸⣧⣵⢏⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿
                ⢟⠈⣴⠟⡩⣣⢞⣽⢿⣤⡈⠙⠣⠾⣿⣿⣿⣿⣿⣿⡷⠀⡽⣿⣿⣻⡇⣟⣿⢻⣶⣧⠜⣿⢿⣿⠿⠾⣛⣭⣷⣶⣿⣿⣿⣿⣿⡇⢠⠇⢾⣷⣽⣹⣿⣿⢸⣿⣿⣿⣿⣿⣿⣿⣿
                ⢨⠸⣋⢞⠕⣡⠞⡡⣀⡽⣷⣜⣿⣿⡿⢿⣿⣿⣿⡿⠁⠃⢸⣮⣿⣿⢸⡻⢷⢻⠟⢫⣚⣯⣬⣵⣾⣿⣿⣿⣿⣿⣿⣿⣿⡿⡫⢦⡞⡠⠾⣫⣷⣿⡿⢿⡞⣿⣿⣿⣿⣿⣿⣿⣿
                ⣷⠸⡡⣋⠞⡡⣪⠔⢁⠜⣸⣿⡝⣿⣿⡆⢹⣿⠋⠀⠀⣀⣼⣿⣿⢋⠔⢃⣭⣶⣿⣿⣿⣿⣿⣿⣿⣿⡏⡾⠿⣭⡯⢿⢏⡪⣼⡿⣱⢣⢾⣻⣿⡟⣿⠹⢹⡽⣿⣿⣿⣿⣿⣿⣿
                ⣿⣇⠸⣧⣞⠼⢁⠖⢡⠞⣡⢊⡻⣮⣿⣷⡞⢯⠰⣾⠱⣿⣱⡾⠃⣠⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⢨⣿⣙⡯⣵⣾⣾⡟⡱⣣⣿⢺⣿⣿⣧⣙⣛⣻⣽⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣷⣌⠳⠶⣩⡔⢁⡶⢡⡾⢡⡧⣛⢮⣍⠀⠲⡜⠷⢉⣓⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣔⠾⣋⣞⢛⣵⠘⣵⣿⣿⣿⣽⢸⢟⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣦⣙⠦⣫⣴⠟⡴⢋⡴⢃⡶⢛⣧⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⡞⣡⣾⣿⣿⣿⣿⣇⢿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣷⣭⡑⠿⣱⣏⣠⠏⣴⢋⡜⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣮⣝⡣⠾⢔⣫⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                
                             %s☀️ O Ataque especial do Luffy Gear 5 está ativo novamente! ☀️
                
                """ + Tools.color.YELLOW_BRIGHT, Tools.color.YELLOW_BRIGHT);

        Tools.pausar();
    }

    public static void kaidoDragao() {
        System.out.printf(Tools.color.RED_BRIGHT + """
                        
                                         🐉 KAIDO ASSUME SUA FORMA DE DRAGÃO! 🐉
                        
                                          Kaido ruge, e sua forma humana desaparece.
                        
                        No lugar, um dragão colossal ergue-se no céu, cobrindo Onigashima com sua sombra.
                        
                                          %sKaido:%s "Eu sou o mais forte do mundo!
                        
                                                  %sTU NÃO PODES GANHAR!"%s
                        
                        """ + Tools.color.YELLOW_BRIGHT,
                Tools.color.GREEN_BRIGHT, Tools.color.GREEN_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.YELLOW_BRIGHT);

        Tools.pausar();
    }

    public static void finalWano() {
        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                                        %s🏯 O NOVO AMANHECER DE WANO ⛩️%s
                        
                        💥 O impacto do último soco de Luffy faz tremer toda a ilha de Onigashima.
                        A gigantesca forma de Kaido despenca dos céus como um meteoro,
                        rasgando as nuvens negras que cobriam Wano por décadas.
                        
                        Seu corpo colide com o solo, abrindo uma cratera colossal.
                        O silêncio toma conta do campo de batalha.🐉
                        
                                              %sKaido caiu.%s
                        
                        🔥 As chamas da guerra começam a se apagar. O céu antes sombrio agora revela
                        os primeiros raios do sol, iluminando a terra com uma luz dourada.
                        
                        """,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT,
                Tools.color.RED_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();

        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        ☀️ %sOs tambores da libertação ecoam por todo Wano.%s ☀️
                        
                        Os samurais, os mink, os piratas e os aldeões… todos olham para o céu.
                        Então, um grito de alegria rompe o silêncio.
                        
                        """,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();

        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣞⠁⣾⣷⢂⢻⣿⡅⢂⣠⢀⣤⣾⣿⣯⢰⣿⡛⠭⣘⣴⣿⣿⡿⠟⢁⡮⢟⣻⣿⡿⢿⣿⡿⣿⣧⣂⠀⣀⣠⣶⣿⣿⣿⣿⡄⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣦⣿⠟⢠⣿⣿⠁⣢⣿⢧⣿⣿⣿⣿⣷⣷⡶⣳⣭⣭⣩⣬⣤⣾⡟⣾⣿⣿⠿⣿⣷⣦⣙⠻⣿⣿⣿⣿⣿⣿⣿⣿⠿⢏⠁⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢉⣡⣾⣿⣿⣿⣿⠿⣟⣾⣿⢳⣨⣿⣿⡛⢇⣽⣿⣿⣿⣿⣿⣿⣧⠹⣿⣿⣶⠈⢿⣿⣿⣧⡉⢿⣿⣿⣽⣿⡷⢋⡈⣀⠀⠀
                        ⠀⠀⠀⠀⡆⠀⠀⠀⠘⣦⡄⠀⠀⣰⣿⣿⣿⣿⢿⣻⣿⣿⣿⣿⣟⠘⣿⣿⣿⣿⣿⣿⣿⣿⣻⣽⣿⡿⣿⣷⣌⠉⠍⠃⢸⣿⣿⣿⡷⡈⢿⣿⣿⡏⣲⣿⡷⢍⣨⢒
                        ⠀⠀⠨⠙⠃⠀⠀⠀⢸⣷⡏⠀⠸⣱⣾⣿⣷⣿⣿⣿⢻⣭⣛⡝⣉⣠⣿⣿⣿⣻⣿⣿⣽⣿⣿⢿⡷⡙⣿⣿⠿⣿⣿⣿⣿⣿⣿⣻⡟⢠⢹⣿⠯⢱⣴⡾⣱⡿⢿⣿
                        ⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡃⠄⣠⣿⣿⡟⣿⣿⣿⣿⠘⡜⢿⣿⣿⣿⣿⣿⣿⣿⠄⡻⢿⣿⣿⢛⡧⠀⣿⣿⣧⠛⢻⡛⠿⠿⠿⠟⠃⠄⢸⣿⠃⣿⣿⣣⠇⡸⢸⣿
                        ⠀⠀⠀⠀⠀⠀⠀⠀⡏⢿⡅⢀⠙⢿⠇⣸⣿⣿⡷⠋⡀⠈⠀⡉⢛⠻⣛⡿⣽⠏⠀⠀⠘⣿⡏⠰⠂⢁⣿⣧⡙⠿⣶⣌⠁⠊⠀⠂⢁⣠⣾⢁⠞⣿⣿⣿⡾⢃⣾⣿
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠜⠸⣿⣶⣤⡾⡀⣏⣿⡗⠠⠑⢀⣴⣿⣶⣄⡁⢈⠀⠁⠀⣰⢎⢸⡟⠀⠡⠀⣺⣿⣿⡟⣰⣤⣤⣤⣴⣾⣿⣿⣿⣿⣼⣼⣿⣟⣶⣶⡿⠛⢉
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠈⢂⠌⠛⠊⠑⢠⠃⡿⠀⠄⣰⣿⣿⣿⣿⣿⠏⢀⡰⢶⣫⠗⠫⠎⠀⢈⣀⠐⢈⠻⡼⣗⠰⡿⣿⠁⡿⢋⡝⠶⣛⠿⢻⠿⠟⣡⢿⢫⣴⣿⣿
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣈⡤⢐⠀⠤⠘⡐⠀⢰⣯⢟⡩⣬⠛⢊⡎⡀⠩⣤⣄⣤⣥⡀⣴⢾⣻⣟⣄⠈⡕⢃⠸⢡⠋⡀⠁⠃⠌⠴⣁⠚⢤⡠⡴⣽⡿⣼⣿⣿⣿
                        ⠀⠀⠀⠀⠀⠀⠀⠀⣠⡾⠟⠙⠂⠀⠂⠄⠐⠀⡞⣭⢆⠾⠜⣼⠟⢀⠀⣠⣿⣿⣿⣿⢻⣭⣿⣳⢟⡾⠀⠐⠀⢀⠆⠊⣤⠞⠋⠛⠱⡄⠩⢄⠳⣱⢎⡵⣛⣟⡿⠟
                        ⠀⠀⠀⠀⠈⠔⠲⠛⠙⠁⢀⡀⠄⠀⠁⡀⣺⠑⠆⣿⣈⠻⠛⠁⠀⣲⣽⣾⣿⣿⢏⣥⢏⣼⣟⣧⠿⠁⠀⠀⠀⠌⢠⡞⠁⠀⠀⠀⠀⡇⡘⠤⢃⡉⡙⠛⠛⢉⡐⡌
                        ⠀⠀⠀⠀⠀⠀⠑⠂⠒⠈⠂⠐⠠⠀⠀⢠⠐⠧⠂⡷⠉⠒⠀⡀⢄⠛⠿⢛⣋⡴⢛⣵⠾⠿⣽⡚⢠⢀⡤⢶⠀⠀⡟⠲⠀⠀⠀⠂⢡⠇⠀⡉⠀⠁⠱⢪⠤⡃⠘⠈
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⡈⢸⠧⠈⠃⢐⣽⣴⣿⣟⣯⣟⣯⣯⣭⣶⠿⠋⢀⠀⠱⣣⢗⡣⡼⢯⡁⢀⠠⠀⠁⠀⠀⠌⡼⠁⢠⢐⡡⠎⡄⠈⢧⡁⢎⡱
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠟⡙⠇⠀⠇⢠⢶⣛⠞⣻⣿⣾⡿⠿⠛⣋⣡⣦⢶⣿⠆⡀⠐⣯⣛⢶⡻⣽⠀⡀⠀⢂⣀⣄⡤⠞⠁⡘⢄⠲⡐⢣⡘⠁⢆⡱⢊⡵
                        ⠀⠀⠀⠀⠀⠀⠀⠠⠤⢤⣶⣻⣞⠇⠀⢂⢸⡆⠳⣄⣥⠿⠋⣡⣴⣾⣿⣿⡿⠻⢈⠫⡀⠀⢸⢧⣛⡾⣹⢳⠀⠀⠈⠓⠉⠂⠀⡀⢀⠠⠌⢢⠱⡡⠜⡱⡊⡔⠋⠐
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠄⠂⠀⠀⡘⡭⢶⠝⣁⣴⣿⣿⡿⢟⣛⣼⣶⣽⣆⢷⣔⢠⡛⣧⢻⡜⣧⠋⠀⠀⠐⠀⠀⠀⠀⡐⢀⠂⠘⡄⢣⠡⣋⠔⠃⢆⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢄⡴⠁⢃⠉⣄⢿⣿⢋⣥⣶⣿⣿⣿⣿⣿⡟⢘⡵⣫⢲⣭⢳⡽⡎⠁⢀⠂⠀⠀⠀⠀⠂⠄⠂⠈⠄⠸⡁⠆⢐⠂⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⠻⣌⠎⢱⣿⣿⣿⣿⣿⡟⢏⣋⡴⣏⠷⣭⢳⣎⠿⡜⠁⠀⠀⠠⠈⡐⠈⠀⠀⠀⠈⠀⠌⠀⠄⡀⠃⠀⠀⠀⠀⢠
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢏⡹⡎⢿⣿⣏⣿⠾⢁⣶⡏⠎⠷⠉⠿⠈⠇⠈⠁⠀⠀⠀⡈⠀⠰⠀⠀⠀⠀⠆⠁⠀⢀⠈⠰⠀⠀⠀⠀⠀⠀⣇
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣽⠲⠜⠬⣖⠽⠋⠀⢀⢀⠠⡀⠀⠂⠀⠀⠀⠀⠀⠐⠠⠈⢀⠐⠀⣲⢌⠠⢈⠐⠀⢈⠀⠀⠀⠀⠀⠀⠘⢤
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠩⣇⣿⣿⠆⣤⠶⠹⠉⠊⠀⠀⠀⠀⠀⠀⠀⠀⡐⢠⣶⠀⠀⡀⢀⣟⢪⠷⡄⠌⠠⠀⠀⠀⠀⠀⠀⠀⡘⠤
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣜⠃⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣐⡼⣳⡿⠀⢀⠀⡸⠆⠘⢋⡉⠴⣀⣖⣰⠢⡄⢄⠀⠐⠈⣐
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠂⠀⠀⣠⠴⠂⠀⠀⠀⠀⠀⣀⣲⡽⣳⢿⡇⠀⠂⡰⠏⣡⡘⢤⣾⣷⣿⡿⠁⠠⠐⣈⣢⣴⣿⣿
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⡠⢄⠀⠀⠀⡠⠔⠋⠀⠀⠀⠀⢠⡔⣀⣡⢾⡱⢯⡽⣿⠂⠁⢀⣡⣾⣵⣿⣿⡿⠟⠿⢻⢿⣿⣿⣿⣿⣿⡻⣿
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡿⣿⣻⡇⠌⢀⠔⠉⠀⠀⠀⠀⠀⣀⠠⠸⣜⡻⣟⢧⡻⢍⢿⠏⠀⢰⣛⠿⠻⠿⠛⣫⣴⣿⣿⣿⣳⡜⢿⣿⣿⣿⡗⡸
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢜⡷⣿⣻⡝⠀⠄⠂⠀⠀⠀⠀⠀⠐⠀⠀⠀⢰⡌⠓⠹⠊⠁⠸⠂⠀⠄⠛⠽⢻⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⡘⣿⠿⡝⡰⢱
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣿⢻⡽⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡳⢆⠀⠀⠠⠁⠀⡐⠨⢄⢀⣠⣴⣯⣿⡿⣻⣽⣷⠿⣻⣿⣿⣄⠚⡔⣡⠣
                        
                                             👒 %s"LUFFY DERROTOU KAIDO!!!" 👒
                        
                        """,
                Tools.color.YELLOW_BRIGHT);

        Tools.pausar();

        System.out.printf(Tools.color.WHITE_BRIGHT + """
                
                🎎 As ruas de Wano são preenchidas com risadas, danças e música.
                O povo, antes oprimido, agora celebra com sakê e fogos de artifício.
                
                🍶 Luffy e sua tripulação são recebidos como heróis. Zoro bebe ao lado dos samurais,
                Sanji cozinha um banquete lendário, e Nami já começa a negociar um tesouro como recompensa.
                
                Mas enquanto todos festejam, Luffy, deitado na relva,
                olha para o céu estrelado e sorri.
                
                        🏴‍☠️ "A próxima aventura está logo ali..."
                
                """);

        Tools.pausar();

        System.out.printf(Tools.color.WHITE_BRIGHT + """
                        
                        ⣌⢻⣿⣿⠇⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠛⠛⠈⠁⠀⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⢀⣴⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⢸⣿⣿⣿⣿
                        ⣿⡆⢿⡟⢠⣿⣿⣿⣿⣿⡿⠋⣿⣿⣿⣿⣿⡿⠋⢀⣴⣶⣆⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠁⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠈⣿⣿⣿⣿
                        ⣿⡟⠀⢠⣿⣿⣿⣿⣏⠋⢀⣼⣿⣿⣿⣿⡟⠁⠀⠘⢿⣿⣿⠀⣾⣿⣿⣿⣿⣿⣿⡿⠟⠉⢠⠔⢂⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡁⠘⣿⣿⣿
                        ⠉⠀⢠⣿⣿⣿⣿⣿⠃⠀⣼⣿⣿⣿⣿⡟⠀⠀⡼⠀⠈⠻⡇⢠⣿⣿⣿⣿⣿⣿⠏⠀⠀⣀⣀⣀⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠙⠀⢹⣿⣿
                        ⣄⠀⣿⣿⣿⣿⣿⠃⠀⠀⣿⣿⣿⣿⠟⠁⠀⣀⣴⣾⣷⠄⠁⠘⣿⣿⣿⣿⡿⠁⠀⢠⣾⠿⣿⣿⣿⣆⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⣀⣤⠀⢿⣿
                        ⠉⠀⠙⠿⠿⠛⠁⠀⢠⡀⠸⢿⣿⡿⠀⠀⣴⣿⠟⠁⣠⠀⠀⠀⢿⣿⣿⣿⠇⢠⡄⢹⣷⡄⠀⣿⣿⡟⢀⣿⡏⢸⣿⣿⣿⣿⡿⠛⣉⡉⠻⣿⣿⣿⣿⣿⠟⢋⣠⣾⣿⣿⠀⢸⣿
                        ⠀⣾⣶⣄⠀⠀⠀⢰⣾⣧⡀⠈⠉⠀⢀⣼⣿⣿⠀⠾⠉⠀⠀⠀⠸⢿⣿⠿⠀⠺⣷⣤⣈⣤⣾⣿⡿⠁⣸⡟⢁⣿⣿⣿⠟⢉⣴⣾⣿⣿⣆⠘⣿⡿⠋⣁⣴⣿⣿⡿⠛⠁⠀⢸⣿
                        ⡀⢸⣿⣿⡄⠀⣸⣿⣿⣿⣷⠀⣠⣄⠸⣿⣿⣿⡀⠰⣄⠀⣰⡶⠀⠀⣀⣀⣀⡀⠙⠿⣿⠿⠟⠋⢀⡴⠋⣠⣾⣿⣿⠋⣠⣿⡟⠛⣿⣿⠏⠀⣀⣴⣾⣿⡿⠟⠋⢀⣠⡶⠀⢸⣿
                        ⣷⣀⠉⠛⠃⠀⣿⣿⣿⣿⣿⣿⣿⣿⡄⠹⣿⣿⣷⡀⠀⠀⠁⣀⣤⣾⣿⣿⣿⡇⠀⠀⡀⠠⣀⣤⣤⣤⣾⣿⣿⣿⠇⠀⣿⣿⣦⡈⠉⣠⣴⣿⣿⠿⠛⠁⠀⢠⣾⣿⡅⠁⢀⣿⣿
                        ⣶⣿⣷⣶⣼⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⣤⡄⠱⠀⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠈⠛⠛⠛⠛⠋⠉⠁⠀⢴⣾⣿⡄⢸⣿⣿⠃⢠⣾⣿⣿
                        ⠙⣿⣿⣿⣿⠀⢿⣿⣿⣿⣿⣿⠉⢿⣿⣿⣿⣦⣤⣉⠛⠻⠿⠿⠟⠛⢋⣁⣤⣾⣿⣷⣶⣦⣿⣿⣿⣿⣿⡟⠀⣠⣶⠀⣴⡆⠀⠰⠋⠀⠈⣡⠄⢠⣿⣿⡇⠈⠟⠃⣰⣿⣿⣿⣿
                        ⡀⠀⠙⠛⠿⠀⢸⣿⣿⣿⡿⠋⣀⠈⠻⣿⣿⣿⣿⣿⣿⣷⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⢠⣿⣿⠀⣿⣧⡀⠒⠤⠤⠤⠋⢀⣾⣿⣿⠇⠀⠀⣼⣿⣿⣿⣿⣿
                        ⣿⣦⣄⠀⠀⠀⠘⣿⣿⣿⠇⢰⣿⣷⣄⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿🏴‍☠️ %sFIM!%s 🏴‍☠️ ⣿⡿⢿⠀⣾⣿⣿⣆⠘⢿⣿⣶⣦⣤⣶⣾⣿⣿⠟⢁⣤⣤⠀⣿⣿⣿⣿⠟⢠
                        ⣿⣿⣿⣿⣦⣀⠀⠈⢿⣿⠀⣾⣿⣿⣿⣷⡀⠈⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢠⣿⠀⣿⣿⣿⣿⣷⣤⣉⣉⡛⢉⣉⣉⣀⣤⣾⣿⣿⣿⠀⠈⢉⣡⢖⣤⣿
                        ⣿⣿⣿⣿⣿⣿⣧⣄⡀⠻⠀⢿⣿⣿⣿⡏⣠⣷⣦⣀⠈⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⠼⠏⠀⣿⣿⡿⠛⠿⣿⣿⣿⣿⢿⣿⠿⠉⣉⣤⣿⣿⠃⠀⠀⣀⣴⡿⠟⣹
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠘⢿⣿⡿⢠⣿⣿⣿⣿⣷⣦⣄⡈⠙⠻⢿⣿⣿⣿⣿⣿⣿⣦⠈⠻⠋⠀⢀⣴⣿⣿⣿⣷⣦⣤⣤⣭⣍⠀⣤⣶⣾⣿⣿⡿⠁⣴⣶⣿⠿⠋⠀⢠⣼
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⠈⢻⠁⣾⣿⣿⣿⣿⣿⣿⡿⢁⣶⣦⣤⣀⠉⠙⠻⠿⣿⣿⣷⣤⣤⣞⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠀⣿⣿⣿⣿⠏⠀⠼⠛⠉⣁⣤⣶⣾⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⢻⣿⣿⣿⣿⣿⣿⢁⣿⣿⣿⣿⣿⣿⣷⡆⢠⣄⣈⣉⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠋⣠⣾⣿⣿⡿⠃⠀⠀⣠⣶⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⣀⠉⠻⣿⣿⣿⢃⣾⣿⣿⣿⣿⣿⣿⡿⢁⣾⣿⣿⣿⣿⠇⣴⣶⣷⣶⣶⠀⣶⣿⠟⣡⣾⣿⣿⣿⠿⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⢸⣿⣦⣄⠙⠋⢼⣿⣿⣿⣿⣿⣿⡿⢁⣾⣿⣿⣿⣿⡏⢠⣿⣿⣿⣿⠇⡸⠟⣁⣶⣿⣿⣿⡿⠋⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                        ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠈⢻⣿⣿⣟⠲⢤⣉⠛⠻⢿⣿⣿⢁⣾⣿⣿⣿⣿⡟⢠⣿⣿⣿⠿⠋⢀⣤⣾⣿⣿⣿⡿⠋⠀⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣻⣭⣶⣾
                        
                        
                        """,
                Tools.color.YELLOW_BRIGHT, Tools.color.WHITE_BRIGHT);

        Tools.pausar();
    }

    public static void perdioJogo() {
        System.out.printf(Tools.color.GREEN_BRIGHT + """
                        
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                              | |                      🐉  %sONIGASHIMA%s  🐉                        | |
                            __| |________________________________________________________________| |__
                           (__   ________________________________________________________________   __)
                              | |                                                                | |
                        
                        """ + Tools.color.RESET,
                Tools.color.RED_BOLD_BRIGHT, Tools.color.GREEN_BRIGHT);
    }
}
