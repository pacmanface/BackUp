class SimUnit{
    String botType;

    SimUnit(String botType){
        this.botType=botType;
    }

    int powerUse(){
        if (botType.equals("Retention machine")) return 2;
        else return 4;
    }
}