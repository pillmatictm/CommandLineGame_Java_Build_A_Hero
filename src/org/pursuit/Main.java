package org.pursuit;

import java.util.Scanner;

public class Main {
    static int hero = 0;
    static int antiHero = 0;
    static int villain = 0;
    static Question[] gameQuestions;

    public static void main(String[] args) {
        Build_a_Hero build_a_hero = new Build_a_Hero();
        build_a_hero.startGame();
        playGame();
    }

    public static void playGame() {
        Question q01 = new Question("What style of hair will your character have?");
        q01.addAnswer("A", new Answer(": Long Red Hair", HeroType.ANTIHERO));
        q01.addAnswer("B", new Answer(": Short Black Hair", HeroType.HERO));
        q01.addAnswer("C", new Answer(": Bald", HeroType.VILLAIN));

        Question q02 = new Question("\nWhat will your character wear on its torso?");
        q02.addAnswer("A", new Answer(": Gold Breast Plate", HeroType.HERO));
        q02.addAnswer("B", new Answer(": Vibranium Suit", HeroType.ANTIHERO));
        q02.addAnswer("C", new Answer(": Suspenders/No Shirt", HeroType.VILLAIN));

        Question q03 = new Question("\nWhat will your character wear on its legs?");
        q03.addAnswer("A", new Answer(": Tights", HeroType.HERO));
        q03.addAnswer("B", new Answer(": Leather pants", HeroType.VILLAIN));
        q03.addAnswer("C", new Answer(": Exo Skeleton", HeroType.ANTIHERO));

        Question q04 = new Question("\nWhat will your character wear on its feet?");
        q04.addAnswer("A", new Answer(": Knives", HeroType.VILLAIN));
        q04.addAnswer("B", new Answer(": Combat Boots", HeroType.ANTIHERO));
        q04.addAnswer("C", new Answer(": Super Speedy Sneakers", HeroType.HERO));

        Question q05 = new Question("\nWhat will your character wear on its head?");
        q05.addAnswer("A", new Answer(": Horned Helmut", HeroType.VILLAIN));
        q05.addAnswer("B", new Answer(": Golden Olive Branch", HeroType.HERO));
        q05.addAnswer("C", new Answer(": Training Mask", HeroType.ANTIHERO));

        Question q06 = new Question("\nWhat accessory will your character carry?");
        q06.addAnswer("A", new Answer(": A Smart Watch", HeroType.HERO));
        q06.addAnswer("B", new Answer(": Sunglasses", HeroType.ANTIHERO));
        q06.addAnswer("C", new Answer(": A Pet Monkey", HeroType.VILLAIN));

        Question q07 = new Question("\nWhat will your character use for a weapon?");
        q07.addAnswer("A", new Answer(": Whip", HeroType.VILLAIN));
        q07.addAnswer("B", new Answer(": Hands", HeroType.ANTIHERO));
        q07.addAnswer("C", new Answer(": Utility Belt", HeroType.HERO));

        Question q08 = new Question("\nWhat kind of vehicle will your character use?");
        q08.addAnswer("A", new Answer(": Motorcycle", HeroType.ANTIHERO));
        q08.addAnswer("B", new Answer(": Commercial Van", HeroType.VILLAIN));
        q08.addAnswer("C", new Answer(": Flight (Self)", HeroType.HERO));

        Question q09 = new Question("\nWhere is your character's secret lair?");
        q09.addAnswer("A", new Answer(": Fortress of Contemplation", HeroType.HERO));
        q09.addAnswer("B", new Answer(": NYC Sewer", HeroType.VILLAIN));
        q09.addAnswer("C", new Answer(": Studio Apartment", HeroType.ANTIHERO));

        Question q10 = new Question("\nWhat secret identity will your character assume in the real world?");
        q10.addAnswer("A", new Answer(": Lawyer", HeroType.VILLAIN));
        q10.addAnswer("B", new Answer(": Wall Street Stock Broker", HeroType.HERO));
        q10.addAnswer("C", new Answer(": Gentlemen's Lounge Lead Bartender/Mixologist", HeroType.ANTIHERO));

        gameQuestions = new Question[]{
                q01,
                q02,
                q03,
                q04,
                q05,
                q06,
                q07,
                q08,
                q09,
                q10
        };

        questionAsk(gameQuestions);

    }

    public static void questionAsk(Question[] gameQuestions) {
        Scanner scanner = new Scanner(System.in);

        for (Question question : gameQuestions) {
            System.out.println(question.getPromptQuestion());
            question.printAnswer();
            String userChoice = scanner.nextLine().toUpperCase();

            while (!(userChoice.charAt(0) == 'A' || userChoice.charAt(0) == 'B' || userChoice.charAt(0) == 'C')) {
                System.out.println("Sorry! Does not compute. Try again!");
                userChoice = scanner.nextLine().toUpperCase();

            }

            checkHeroValue(userChoice, question);
        }

        if (hero > antiHero && hero > villain)
            System.out.println("\nCongratulations! You've built a HERO! \n \n" +
                    "                             .-\"\"\"-.    __                         \n" +
                    "                            /       \\.q$$$$p.                      \n" +
                    "                         __:  db     $$$$$$$$b.                    \n" +
                    "                  _._.-\"\"  :  $\"b.   :$$$S$$$$$b                   \n" +
                    "                .'   \"-.  \"   T. `b d$$$S$S$$$$P^.              .-,\n" +
                    "    .qp.       :        `.     TsP' TSSS$P'S$P'   `.            `dP\n" +
                    " ,q$$$$$b      ;b         \\  '.     /\"T$P  :P       `.      __ dP_,\n" +
                    " :$$$$SS$b_    $$b.  __.   ;_  `-._/   Y    \\         `.   ( dP\".';\n" +
                    " $$$$$$$S$$b.  :S$$$p._    $$$$p./      ;    \"-._       `--dP .'  ;\n" +
                    ":$$$$P^^TS$$$b  SS$$$$$$   'T$$$$b.     ;        \"\"--.   dP  /   / \n" +
                    "$$$$P    :$$$$bd$SSS$$$;\\  . \"^$$$$b___/            __\\dP .-\"_.-\"  \n" +
                    "$$$P     $$$$$$b`T$SSS$  \"-.J   \"^T$/  \"\"-._       ( dP\\ /   /     \n" +
                    ":$$      ; T$$$$b.`T$$;     d$+.     \"\"-.   \"\"--.._dP-, `._.\"      \n" +
                    " T;     :   T$$$$$b.`^'   _d$P .$p.___   \"         \\`-'            \n" +
                    "  `.    ;    T$$$$$$b._.dS$$$ :$$$b\"--..__..---g,   \\              \n" +
                    "    `. :      $$$$$$$$$$S$$$P\\ TP^\"\\       ,-dP ;    ;             \n" +
                    "      \\;   .-'$$$$$$$SSSP^^\"  \\     `._,-.-dP-' |    ;             \n" +
                    "       :     :\"^^\"\" \"\"\"        `.   `._:'.`.\\   :    ;\\            \n" +
                    "        \\  , :              bug  \"-. (,j\\ ` /   ;\\(// \\\\           \n" +
                    "         `:   \\                     \"dP__.-\"    '-\\\\   \\;          \n" +
                    "           \\   :                .--dP,             \\;              \n" +
                    "            `--'                `dP`-'                             \n" +
                    "                              .-j                                  \n" +
                    "                              `-:_                                 \n" +
                    "                                 \\)                                \n" +
                    "                                  `--'" +
                    "\n \nYou were destined to be different from birth. Due to a freak accident your mother survived while carrying you, \nyou acquired mutant genes. Your left side has the ability to control light energy, your right side, dark. " +
                    "\nYour mutant appearance has led you to live a difficult life. Despite the hardships, you remained strong, \nfound other mutants with like intentions, and stand together as a team to fight against evil ");


        else if (antiHero > hero && antiHero > villain)
            System.out.println("\nCongratulations! You've built an ANTI-HERO! \n \n" +
                    "                            __          .gp.__/                            \n" +
                    "                       .ssSSSSSs.__    d$P^^^\"                             \n" +
                    "                    .sSSSSSSS$$$$$$$p.dP                                   \n" +
                    "                  .SSSSSS$$$$$SSSSSSSS$bs+._                               \n" +
                    "                .SSSS$$$$$SSSSS$$$$$$$SS$$$$b__                       /\"-. \n" +
                    "                SSS$$$SSSSS$$$$$$$$SSSS$$$SSSS$b                   _/\"-. / \n" +
                    "               :S$$$SSSSS$$$$$$$SSSSS$$$SSSS$$SSb                 //   /\"-.\n" +
                    "               $$SSSSS$$$$$$SSSSS$$$$$$S$$$$S$$$Sb.               ;   /   /\n" +
                    "               SSSSS$$$$$SSSSS$$$$$$$SS'P   SS$$S`^b._.'         /:  :   / \n" +
                    "               :S$$$$$SSSSS$$$$$$$SSSP      :$SS$b              / ;  +-./  \n" +
                    "                $$$$SSSS$$$$$$$SSSSSP        S$SS$;            / /  / / ;  \n" +
                    "               d$$SSS$$$$$SSSSSSSSS' ,=._    :S':S$           / /  / / /   \n" +
                    "              :$SSS$$$$SSSSSSSSS^\"  '  _ \";  ;   S$          / /  / / /    \n" +
                    "              SSS$$$SSSP.-TSS^\"     .=\"$;   /    S;         / /  / / /     \n" +
                    "             :SS$$$SSS$$ (;            \"    \\    P         / /  / : :      \n" +
                    "             :S$$$SS$$$$b :                  \\ .'         / /  /  :  \\     \n" +
                    "              T$$SS$$$$$j`-,    .          ,  \\         /\"-(  /   ;_-.\\    \n" +
                    "               `TSS$$$$P   ;    `.         `.-'        /  /\\\\/   .'/_ ;;   \n" +
                    "                 TS$$$P    :             _.-;         /  /\\\\(   / /-\" ;;   \n" +
                    "                  SSS'      \\           :-t\"         : .-\\\\/ \"-/\":   //    \n" +
                    "                .SS$$        `.          `-;  bug    )Y   y   /  ;  J/     \n" +
                    "               :S$$$;          \"-.        (          '\"; j_.-/-./.-\" \\_    \n" +
                    "               $S$SS              \"j.     :            :/  ':    `-..' \\   \n" +
                    "              d$$SS;     :        /  \"-._.'             `.  ;       `-./;  \n" +
                    "            _S$$$SP       \\      :                        \\: :\"-.      \\;  \n" +
                    "          ,$$$SSSj       , `.    ;                         : ;   \"-,   /   \n" +
                    "          S$$SS'\"^-...___       : \"-.                      ;/      ;  t    \n" +
                    "      __.-`SS'---. `T$$$$$$q._       \"-.                  / `.    /   ;    \n" +
                    "  .-\"\"__ `.'      `. `T$$$$$$$$b.       `.               :    \"--\"   /     \n" +
                    " /.-\"\"  \\/          `. T$$$$$$$$$$p.     .`._            /\"-.  _   .'      \n" +
                    "::      /             \\ T$$$$$SS$$$$$b._  `.T$p.        /    \"\" ;-'        \n" +
                    ";;     :               \\ T$$$S$$$$$$$$$$$p._L$$$$p.    /       ,           \n" +
                    ";;     ;                \\ $$$$$$$$$$$$$$$$$$$SS$$$$$. /                    \n" +
                    "::     ;                 ;:$$$$$$$$$$$$$$SSSSSSSSS$$$y        '            \n" +
                    " ;;    :                  \"^$$$$$$$$$$$$$$$$$SSSS$$$P        /             \n" +
                    " ;;     b.                   \"^$$$$$$$$$$$$$$$$$S$$'        /              \n" +
                    " ::     :$$p.  -._              \"^$$$$$$$$$$$$$$$'         /               \n" +
                    "  ;;     $$$$$p.                   \"^$$$$$$$$$$P          /                \n" +
                    "  ::     :$$$$$$p.                    \"^$$$$$$P          ,                 \n" +
                    "   ;;     T$$$$$$$$p.                    \"^$$P                             \n" +
                    "   ::      T$$$$$$$P \"-.                    \"           '                  \n" +
                    "   s;;      $$$$$$P   d$$p._                     /     /                   \n" +
                    "  S$$:      $$$$$t   d$$$$$$$p._          \"-.  .'     /                    \n" +
                    "  SS$;;     :P^\"\\ \\.d$$$$$$$$$$$$p._         \"\"      /                     \n" +
                    "   TS::      \\   d$$$$$$$$$$$$$$$$$$$p._            /                      \n" +
                    "    SS.\\     .jq$$$$$$$$$$$$$$$$$$^^^^^\"\"-._      .';                      \n" +
                    "   $$$$.tsssj' `T$$$$$$$^^^^^\"\"\"            \"-._.'  ;                      \n" +
                    "   $$$SSS         \\                 /            \\ :                       \n" +
                    "   '^SSS_          \\               :          :    :                       \n" +
                    "     $$$SS.         \\              ;          :    ;                       \n" +
                    "     '$$$SS          \\            :           ;   :                        \n" +
                    "       \"^S$.          \\           ;          :    :                        \n" +
                    "         S$$b.         \\                     ;    ;                        \n" +
                    "         S$$$$          ;                   :    :                         \n" +
                    "         'TSS$$$s.      :                   ;    ;                         \n" +
                    "             TS$$Ss_    ;                   ;   :                          \n" +
                    "              `SSS$$$p./                   :    ;                          \n" +
                    "                  TS$$'            ;       ;    :                          \n" +
                    "                   \"S              :       ;     ;                         \n" +
                    "                   /                ;      :     :                         \n" +
                    "                  /                 :            :                         \n" +
                    "                 /\"-.                          .' ;                        \n" +
                    "                /    \"\"--..__          __..--\"\"   :                        " +
                    "\n \nDuring your college years, you get into a relationship with who you believe to be iss the love your life. " +
                    "\nDespite years of loving and caring for them unconditionally, one day,\nyou get home from a long exhausting day of school and work... " +
                    "\nto find them in your bed with someone else. You hit the ceiling, \nlaying hands on anything in your path before packing a bag of essentials and disappearing" +
                    "\nAfter the incident, and a few years suffering from dispiritedness,\nyou relocate to the other side of the country for a fresh start. " +
                    "\nThere, you turn your lifestyle around while remaining isolated. \nFrom the shadows, you vow to protect loving people from domestic crises and aid them back on to the right path");

        else System.out.println("\nCongratulations! You've built a VILLAIN! \n \n" +
                    "                        .-\"\"\"\"-.\n" +
                    "                       / j      \\\n" +
                    "                      :.d;       ;\n" +
                    "                      $$P        :\n" +
                    "           .m._       $$         :\n" +
                    "          dSMMSSSss.__$$b.    __ :\n" +
                    "         :MMSMMSSSMMMSS$$$b  $$P ;\n" +
                    "         SMMMSMMSMMMSSS$$$$     :b\n" +
                    "        dSMMMSMMMMMMSSMM$$$b.dP SSb.\n" +
                    "       dSMMMMMMMMMMSSMMPT$$=-. /TSSSS.\n" +
                    "      :SMMMSMMMMMMMSMMP  `$b_.'  MMMMSS.\n" +
                    "      SMMMMMSMMMMMMMMM \\  .'\\    :SMMMSSS.\n" +
                    "     dSMSSMMMSMMMMMMMM  \\/\\_/; .'SSMMMMSSSm\n" +
                    "    dSMMMMSMMSMMMMMMMM    :.;'\" :SSMMMMSSMM;\n" +
                    "  .MMSSSSSMSSMMMMMMMM;    :.;   MMSMMMMSMMM;\n" +
                    " dMSSMMSSSSSSSMMMMMMM;    ;.;   MMMMMMMSMMM\n" +
                    ":MMMSSSSMMMSSP^TMMMMM     ;.;   MMMMMMMMMMM\n" +
                    "MMMSMMMMSSSSP   `MMMM     ;.;   :MMMMMMMMM;\n" +
                    "\"TMMMMMMMMMM      TM;    :`.:    MMMMMMMMM;\n" +
                    "   )MMMMMMM;     _/\\\\    :`.:    :MMMMMMMM\n" +
                    "  d$SS$$$MMMb.  |._\\\\\\   :`.:     MMMMMMMM\n" +
                    "  T$$S$$$$$$$$$$m;O\\\\\\\\\"-;`.:_.-  MMMMMMM;\n" +
                    " :$$$$$$$$$$$$$$$b_l./\\\\ ;`.:    mMMSSMMM;\n" +
                    " :$$$$$$$$$$$$$$$$$$$./\\\\;`.:  .$$MSMMMMMM\n" +
                    "  $$$$$$$$$$$$$$$$$$$$. \\\\`.:.$$$$SMSSSMMM;\n" +
                    "  $$$$$$$$$$$$$$$$$$$$$. \\\\.:$$$$$SSMMMMMMM\n" +
                    "  :$$$$$$$$$$$$$$$$$$$$$.//.:$$$$SSSSSSSMM;\n" +
                    "  :$$$$$$$$$$$$$$$$$$$$$$.`.:$$SSSSSSSMMMP\n" +
                    "   $$$$$$$$$;\"^$J \"^$$$$;.`.$$P  `SSSMMMM\n" +
                    "   :$$$$$$$$$       :$$$;.`.P'..   TMMM$$b\n" +
                    "   :$$$$$$$$$;      $$$$;.`/ c^'   d$$$$$S;\n" +
                    "   $$$$$S$$$$;      '^^^:_d$g:___.$$$$$$SSS\n" +
                    "   $$$$SS$$$$;            $$$$$$$$$$$$$$SSS;\n" +
                    "  :$$$SSSS$$$$            : $$$$$$$$$$$$$SSS\n" +
                    "  :$P\"TSSSS$$$            ; $$$$$$$$$$$$$SSS;\n" +
                    "  j    `SSSSS$           :  :$$$$$$$$$$$$$SS$\n" +
                    " :       \"^S^'           :   $$$$$$$$$$$$$S$;\n" +
                    " ;.____.-;\"               \"--^$$$$$$$$$$$$$P\n" +
                    " '-....-\"  bug                  \"\"^^T$$$$P\"" +
                    "\n \nYou're a big shot, tailored-suited, slick-back haired lawyer with a $#!T-eating grin. \nThroughout the years, you've won almost every case, even the ones that were heavily stacked against you. " +
                    "\nThings begin to turn when you accept the case for a major drug kingpin. \nHe has you hang close by him during the duration of the trial to best prepare you for the trial. As you dive further into the case, " +
                    "\nyou realize this case might be your tremendous loss, but, youre not willing to give up the lump sum the mob paid to you in advanced. \nYou have other plans ready to set into motion. The day of the verdict comes. " +
                    "\nThe grand jury sentences the kingpin. Later that night the mob comes to take you out. \nBut you anticipated a war. You take everyone out, leaving the boss' right hand man staring down the barrel of your gun. " +
                    "\nBut you spare his life, explaining your overrunning of the mob and its operations. \nNow you're the new kingpin who runs the city.");
        endGame();

    }

    private static void checkHeroValue(String userChoice, Question question) {
        HeroType heroType = question.getAnswer(userChoice).getHeroType();
        switch (heroType) {
            case HERO:
                hero++;
                break;
            case ANTIHERO:
                antiHero++;
                break;
            case VILLAIN:
                villain++;

        }

    }

    public static void endGame() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("\nPlay Again? [Y/N]: ");
            input = scanner.nextLine().toUpperCase();
            Build_a_Hero buildAHero = new Build_a_Hero();

            if (input.length() == 0 || input.charAt(0) == 'Y') {
                buildAHero.startGame();
                playGame();

            } else if (input.charAt(0) == 'N') {
                System.out.println("Thanks for playing! Goodbye!");

            } else {
                System.out.println("Sorry! Input is invalid. Please, Try again!");
            }

        } while ((input.length() != 0 || input.charAt(0) != 'Y'));
    }
}
