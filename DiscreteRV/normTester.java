import java.lang.Math;
public class normTester
{
    public static void tester(double inMu, double inSig, int numGen){
        double mu = inMu; double sig = inSig;
        NormDev tested = new NormDev(inMu, inSig, 100);
        double stdDev = 0;
        
        int[] zones = new int[5];
        for(int c = 0; c<5; c++){
            zones[c] = 0;
        }
        double tot = 0.0;
        double tot2 = 0.0;
        
        for(int c = 0; c<numGen; c++){
            double testing = tested.genNorm();
            tot += testing;
            tot2 += (testing*testing);
            if(testing>(mu - .5*sig)&&testing<(mu + .5*sig)){
                zones[0]++;
            }
            else if((testing>(mu-sig)&&testing<(mu - .5*sig))||(testing>(mu + .5*sig)&&testing<(mu+sig))){
                zones[1]++;
            }
            else if((testing>(mu-2*sig)&&testing<(mu - sig))||(testing>(mu + sig)&&testing<(mu+2*sig))){
                zones[2]++;
            }
            else if((testing>(mu-3*sig)&&testing<(mu - 2*sig))||(testing>(mu + 2*sig)&&testing<(mu+3*sig))){
                zones[3]++;
            }
            else if((testing>(tested.r*(-1.0))&&testing<(mu - 3*sig))||(testing>(mu + 3*sig)&&testing<(tested.r))){
                zones[4]++;
            }
        }
        
        stdDev = tot2;
        double num = Math.pow(tot,2)/(1.0*numGen);
        stdDev -= num;
        
        stdDev /= (numGen-1);
        
        stdDev = Math.sqrt(stdDev);
        
        
        System.out.println("Actual     Expected");
        System.out.println(zones[0]/(1.0*numGen) + "   0.382925");
        System.out.println(zones[1]/(1.0*numGen) + "   0.299765");
        System.out.println(zones[2]/(1.0*numGen) + "   0.271810");
        System.out.println(zones[3]/(1.0*numGen) + "   0.042800");
        System.out.println(zones[4]/(1.0*numGen) + "   0.002700");
        
        System.out.println("");
        
        System.out.println("Mean: " + (tot/numGen) + "   " + mu);
        System.out.println("Std Dev: " + stdDev + "   " + sig);
        
    }
}
