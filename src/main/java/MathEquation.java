public class MathEquation {
    private LogarithmManagement logarithmManagement;
    private TrigonometricFunctions trigonometricFunctions;

    public MathEquation(){
        this.trigonometricFunctions = new TrigonometricFunctions();
        this.logarithmManagement = new LogarithmManagement();
    }

    public MathEquation(LogarithmManagement logarithmManagement, TrigonometricFunctions trigonometricFunctions){
        this.trigonometricFunctions = trigonometricFunctions;
        this.logarithmManagement = logarithmManagement;
    }
    public double getResult(double x, double accuracy) {
        double result;
        if (x > 0) {
            result = ((((( Math.pow(logarithmManagement.getNaturalLogarithm(x, accuracy), 2) ) - logarithmManagement.getLogarithmFifthBase(x, accuracy) ) + logarithmManagement.getLogarithmSecondBase(x, accuracy) )
                    * ((( logarithmManagement.getLogarithmSecondBase(x, accuracy) - logarithmManagement.getLogarithmFifthBase(x, accuracy) ) / ( logarithmManagement.getLogarithmTenthBase(x, accuracy) + logarithmManagement.getLogarithmTenthBase(x, accuracy) ))
                    - logarithmManagement.getLogarithmThirdBase(x, accuracy) )) - ( logarithmManagement.getLogarithmThirdBase(x, accuracy) + ( logarithmManagement.getLogarithmTenthBase(x, accuracy) / ( logarithmManagement.getNaturalLogarithm(x, accuracy) / logarithmManagement.getLogarithmSecondBase(x, accuracy) ))));
        }else {
            result = (((((( Math.pow( trigonometricFunctions.getCsc(x, accuracy) + trigonometricFunctions.getSec(x, accuracy), 3)) - trigonometricFunctions.getSin(x, accuracy)) + trigonometricFunctions.getCos(x, accuracy)) / trigonometricFunctions.getCot(x, accuracy)) / trigonometricFunctions.getSin(x, accuracy)) / (trigonometricFunctions.getSec(x, accuracy) - trigonometricFunctions.getCsc(x, accuracy)));
        }
        Writer.write(x, result, Modules.System);
        return result;
    }
}
