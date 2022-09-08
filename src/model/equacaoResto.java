package src.model;

public class equacaoResto {
    private int a = 0;
    private int b = 0;
    private int n = 0;
    private int x = 0;

    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }
    public int getn(){
        return n;
    }
    public int getX(){
        return x;
    }
    public void setX(){
        boolean valid = false;
        if (a == b){
            x = 1;
            return;
        };
        if (a == 1){
            x = b;
            return;
        };
        for (int i = 1; valid == false ; i++){
            if (b == ((a*i) % n)){                
                x = i;
                valid = true;
                return;
            }
        };
    }
    public void setValues(int x, int y, int z){
        a = x;
        b = y;
        n = z;
    }
}
