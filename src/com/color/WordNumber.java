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

    private String word;
    private String number;
    private StringBuilder stringBuilder;

    public WordNumber(String word, String number) {
        Integer.parseInt(number);
        this.word = word;
        this.number = number;
        stringBuilder = new StringBuilder();
    }


    private StringBuilder generate() {
        for (int line = 0; line < 5; line++) {
            for (int wordIndex = 0; wordIndex < word.length(); wordIndex++) {
                char wordChar = word.charAt(wordIndex);
                stringBuilder.append("　");
                if (wordIndex < number.length()) {
                    char numberChar = number.charAt(wordIndex);
                    int num = Integer.parseInt(numberChar + "");
                    boolean[] wordRectangular = numberRectangular[num][line];
                    for (boolean b : wordRectangular) {
                        if (b) {
                            stringBuilder.append(wordChar);
                        } else {
                            stringBuilder.append("　");
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

    public void print() {
        System.out.println(generate().toString());
    }

    public void write2File(File file) {

    }


}
