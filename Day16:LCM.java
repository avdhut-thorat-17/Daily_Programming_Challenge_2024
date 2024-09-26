class LCM{
    public int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public int lcm(int a, int b){
        return a*b / gcd(a,b);
    } 
    public static void main(String[] args){
        LCM o = new LCM();
        System.out.println(o.lcm(7,9));
    }
}