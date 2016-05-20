package com.color;

import java.io.File;

/**
 * Created by lixinyuan on 16/5/20.
 */
public class WordNumber {

    private boolean[][][] numberRectangular = new boolean[][][]{
            /*0*/ {{true, true, true, true}
            , {true, false, false, true}
            , {true, false, false, true}
            , {true, false, false, true}
            , {true, true, true, true}}
          /*1*/, {{false, true, true, false}
            , {false, true, true, false}
            , {false, true, true, false}
            , {false, true, true, false}
            , {false, true, true, false}}
           /*2*/, {{true, true, true, true}
            , {false, false, false, true}
            , {true, true, true, true}
            , {true, false, false, false}
            , {true, true, true, true}}
           /*3*/, {{true, true, true, true}
            , {false, false, false, true}
            , {true, true, true, true}
            , {false, false, false, true}
            , {true, true, true, true}}
            /*4*/, {{true, false, false, true}
            , {true, false, false, true}
            , {true, true, true, true}
            , {false, false, false, true}
            , {false, false, false, true}}
           /*5*/, {{true, true, true, true}
            , {true, false, false, false}
            , {true, true, true, true}
            , {false, false, false, true}
            , {true, true, true, true}}
            /*6*/, {{true, true, true, true}
            , {true, false, false, false}
            , {true, true, true, true}
            , {true, false, false, true}
            , {true, true, true, true}}
            /*7*/, {{true, true, true, true}
            , {false, false, false, true}
            , {false, false, false, true}
            , {false, false, false, true}
            , {false, false, false, true}}
            /*8*/, {{true, true, true, true}
            , {true, false, false, true}
            , {true, true, true, true}
            , {true, false, false, true}
            , {true, true, true, true}}
            /*9*/, {{true, true, true, true}
            , {true, false, false, true}
            , {true, true, true, true}
            , {false, false, false, true}
            , {false, false, false, true}}

    };


    private boolean[][] roundZero = new boolean[][]{{false, false, true, true, false, false}
            , {false, true, false, false, true, false}
            , {true, false, false, false, false, true}
            , {false, true, false, false, true, false}
            , {false, false, true, true, false, false}};

    public WordNumber() {

    }


    private StringBuilder generate(String word, String number) {

        boolean isRound = false;
        if (null == number || "".equals(number)) {
            isRound = true;
            number = "520";
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int line = 0; line < 5; line++) {
            for (int wordIndex = 0; wordIndex < word.length(); wordIndex++) {
                char wordChar = word.charAt(wordIndex);
                stringBuilder.append("　");

                if (wordIndex < number.length()) {
                    char numberChar = number.charAt(wordIndex);
                    int num = Integer.parseInt(numberChar + "");
                    boolean[] wordRectangular = null;
                    if (0 == num && isRound) {
                        wordRectangular = roundZero[line];
                    } else {
                        wordRectangular = numberRectangular[num][line];
                    }

                    for (int i = 0; i < wordRectangular.length; i++) {
                        boolean b = wordRectangular[i];

                        if (b) {
                            if ((0 == num && isRound) && i > 2 && word.length() > 3) {
                                stringBuilder.append(word.charAt(wordIndex + 1));
                            } else {
                                stringBuilder.append(wordChar);
                            }
                        } else {
                            if ((0 == num && isRound) || isEnglishChar(wordChar)) {
                                stringBuilder.append(" ");
                            } else {
                                stringBuilder.append("　");
                            }
                        }
                    }
                } else {
                    break;
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder;

    }


    public void print(String word, String number) {
        Integer.parseInt(number);

        System.out.println(generate(word, number).toString());
    }

    public void print(String word) {
        System.out.println(generate(word, null).toString());
    }


    public void write2File(File file) {

    }

    public static boolean isEnglishChar(char c) {
        if (c <= '9' && c >= '0') {
            return true;
        }

        if (c <= 'z' && c >= 'a') {
            return true;
        }

        if (c <= 'Z' && c >= 'A') {
            return true;
        }

        return false;
    }

}
