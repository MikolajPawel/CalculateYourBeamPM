package com;


public class FasteningVisions {

    public boolean[] vis;
    public String imagePath;
    public int type;
    public String savingImagePath;

    /*

    vis[0] -> F1 Vision
    vis[1] -> F2 Vision
    vis[2] -> F3 Vision
    vis[3] -> F4 Vision
    vis[4] -> F5 Vision
    vis[5] -> Q1 Vision
    vis[6] -> Q2 Vision
    vis[7] -> Q3 Vision
    vis[8] -> Q4 Vision
    vis[9] -> Q5 Vision
    vis[10] -> AB Vision
    vis[11] -> BC Vision
    vis[12] -> CD Vision
    vis[13] -> DE Vision
    vis[14] -> EF Vision

    vis[15] -> RAY Vision
    vis[16] -> RAX Vision
    vis[17] -> MA Vision
    vis[18] -> RBY Vision
    vis[19] -> RBX Vision
    vis[20] -> MB Vision
    vis[21] -> RCY Vision
    vis[22] -> RCX Vision
    vis[23] -> MC Vision
    vis[24] -> RDY Vision
    vis[25] -> RDX Vision
    vis[26] -> MD Vision
    vis[27] -> REY Vision
    vis[28] -> REX Vision
    vis[29] -> ME Vision
    vis[30] -> RFY Vision
    vis[31] -> RFX Vision
    vis[32] -> MF Vision

    vis[33] -> F1 Require
    vis[34] -> F2 Require
    vis[35] -> F3 Require
    vis[36] -> F4 Require
    vis[37] -> F5 Require
    vis[38] -> Q1 Require
    vis[39] -> Q2 Require
    vis[40] -> Q3 Require
    vis[41] -> Q4 Require
    vis[42] -> Q5 Require
    vis[43] -> AB Require
    vis[44] -> BC Require
    vis[45] -> CD Require
    vis[46] -> DE Require
    vis[47] -> EF Require

    vis[48] -> Numerical Calculation - is available?

     */

    public FasteningVisions(int cs) {
        switch (cs) {
            case 0 -> {
                this.vis = new boolean[]{
                        true, true, true, true, true,
                        true, true, true, true, true,
                        true, true, true, true, true,

                        true, true, true,
                        true, true, true,
                        true, true, true,
                        true, true, true,
                        true, true, true,
                        true, true, true,

                        false, false, false, false, false,
                        false, false, false, false, false,
                        false, false, false, false, false,

                        false
                };
                this.imagePath = "/fastening_images/default.png";
                this.type = 0;
                this.savingImagePath = "/fastening_images/type_1_save.png";
            }

            case 1 -> {
                this.vis = new boolean[]{
                        false, false, false, false, false,
                        true, false, false, false, false,
                        true, false, false, false, false,

                        true, false, false,
                        true, false, false,
                        false, false, false,
                        false, false, false,
                        false, false, false,
                        false, false, false,

                        false, false, false, false, false,
                        false, false, false, false, false,
                        true, false, false, false, false,

                        true
                };
                this.imagePath = "/fastening_images/type_1.png";
                this.type = 1;
                this.savingImagePath = "/fastening_images/type_1_save.png";
            }

            case 2 -> {
                this.vis = new boolean[]{
                        false, false, false, false, false,
                        true, false, false, false, false,
                        true, false, false, false, false,

                        true, false, true,
                        true, false, false,
                        false, false, false,
                        false, false, false,
                        false, false, false,
                        false, false, false,

                        false, false, false, false, false,
                        false, false, false, false, false,
                        true, false, false, false, false,

                        false
                };
                this.imagePath = "/fastening_images/type_2.png";
                this.type = 2;
                this.savingImagePath = "/fastening_images/type_2_save.png";
            }

            case 3 -> {
                this.vis = new boolean[]{
                        false, false, false, false, false,
                        true, false, false, false, false,
                        true, false, false, false, false,

                        true, false, false,
                        false, false, false,
                        true, false, false,
                        false, false, false,
                        false, false, false,
                        false, false, false,

                        false, false, false, false, false,
                        false, false, false, false, false,
                        true, false, false, false, false,

                        true
                };
                this.imagePath = "/fastening_images/type_3.png";
                this.type = 3;
                this.savingImagePath = "/fastening_images/type_3_save.png";
            }

            case 4 -> {
                this.vis = new boolean[]{
                        false, false, false, false, false,
                        true, false, false, false, false,
                        true, false, false, false, false,

                        true, false, false,
                        false, false, false,
                        false, false, false,
                        true, false, false,
                        false, false, false,
                        false, false, false,

                        false, false, false, false, false,
                        false, false, false, false, false,
                        true, false, false, false, false,

                        true
                };
                this.imagePath = "/fastening_images/type_4.png";
                this.type = 4;
                this.savingImagePath = "/fastening_images/type_4_save.png";
            }

            case 5 -> {
                this.vis = new boolean[]{
                        true, true, false, false, false,
                        true, false, false, false, false,
                        true, false, false, false, false,

                        false, false, false,
                        true, false, false,
                        true, false, false,
                        false, false, false,
                        false, false, false,
                        false, false, false,

                        false, false, false, false, false,
                        false, false, false, false, false,
                        true, false, false, false, false,

                        true
                };
                this.imagePath = "/fastening_images/type_5.png";
                this.type = 5;
                this.savingImagePath = "/fastening_images/type_5_save.png";
            }

            case 6 -> {
                this.vis = new boolean[]{
                        true, true, false, false, false,
                        true, false, false, false, false,
                        true, true, true, false, false,

                        true, false, true,
                        false, false, false,
                        false, false, false,
                        false, false, false,
                        false, false, false,
                        false, false, false,

                        false, false, false, false, false,
                        false, false, false, false, false,
                        true, true, true, false, false,

                        false
                };
                this.imagePath = "/fastening_images/type_6.png";
                this.type = 6;
                this.savingImagePath = "/fastening_images/type_6_save.png";
            }

            case 7 -> {
                this.vis = new boolean[]{
                        true, true, false, false, false,
                        true, false, false, false, false,
                        true, true, true, false, false,

                        false, false, false,
                        true, true, false,
                        true, false, false,
                        false, false, false,
                        false, false, false,
                        false, false, false,

                        false, false, false, false, false,
                        false, false, false, false, false,
                        true, true, true, false, false,

                        true
                };
                this.imagePath = "/fastening_images/type_7.png";
                this.type = 7;
                this.savingImagePath = "/fastening_images/type_7_save.png";
            }

            case 8 -> {
                this.vis = new boolean[]{
                        true, true, false, false, false,
                        true, false, false, false, false,
                        true, true, true, false, false,

                        false, false, false,
                        true, false, false,
                        false, false, false,
                        true, false, false,
                        false, false, false,
                        false, false, false,

                        false, false, false, false, false,
                        false, false, false, false, false,
                        true, true, true, false, false,

                        true
                };
                this.imagePath = "/fastening_images/type_8.png";
                this.type = 8;
                this.savingImagePath = "/fastening_images/type_8_save.png";
            }

            case 9 -> {
                this.vis = new boolean[]{
                        true, true, false, false, false,
                        true, false, false, false, false,
                        true, true, true, true, false,

                        false, false, false,
                        true, false, false,
                        false, false, false,
                        false, false, false,
                        true, false, false,
                        false, false, false,

                        false, false, false, false, false,
                        false, false, false, false, false,
                        true, true, true, true, false,

                        true
                };
                this.imagePath = "/fastening_images/type_9.png";
                this.type = 9;
                this.savingImagePath = "/fastening_images/type_9_save.png";
            }

            case 10 -> {
                this.vis = new boolean[]{
                        true, true, false, false, false,
                        true, false, false, false, false,
                        true, true, true, true, true,

                        true, false, false,
                        false, false, false,
                        false, false, false,
                        false, false, false,
                        false, false, false,
                        true, false, false,

                        false, false, false, false, false,
                        false, false, false, false, false,
                        true, true, true, true, true,

                        true
                };
                this.imagePath = "/fastening_images/type_10.png";
                this.type = 10;
                this.savingImagePath = "/fastening_images/type_10_save.png";
            }


            }

        }


}




