 public static double[] DFT(double data[],int freq,int harmonics){

        int size=data.length;
        double Xk[]=new double[harmonics];
        double realX[]=new double[harmonics];
        double imgX[]=new double[harmonics];
        
        Xk[0]=0;
        realX[0]=0;
        imgX[0]=0;
        
        for(int k=1;k<8;k++){

            for(int n=0;n<size;n++){

                double cos=Math.PI*2*freq*n*k;
                cos=Math.cos(cos);

                double sin=Math.PI*2*freq*n*k;
                sin=Math.sin(sin);

                realX[k]+=(data[n]*cos);
                imgX[k]+=(data[n]*sin);

            }

        Xk[k]=(realX[k]*realX[k])+(imgX[k]*imgX[k]);
            Xk[k]=Math.sqrt(Xk[k]);

        }

        return Xk;
    }
