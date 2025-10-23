import java.text.DecimalFormat;

public class tempConverter {
    enum Messages{
        DEFAULT("\nNo arguments passed in\nTemplate: java tempConverter.java [number] [flag]"),
        FLAGS("\nAvailable flags: \n\t-f convert to Fahrenheit\n\t-c convert to Celsius");

        private final String message;

        private Messages(String message){
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }

    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println(Messages.DEFAULT.toString());
            System.out.println(Messages.FLAGS.toString());
            return;
        }

        if(!checkValue(args[0])) {
            System.out.println("Wrong value");
            return;
        }
        if(!checkFlag(args[1])){
            System.out.println("Wrong flag" + Messages.FLAGS.toString());
            return;
        }

        DecimalFormat df = new DecimalFormat("#.00");
        if(args[1].toLowerCase().charAt(1) == 'c'){
            System.out.print( df.format((Double.parseDouble(args[0]) - 32d) * 5d / 9d) + " \u00B0C");
        }else if(args[1].toLowerCase().charAt(1) == 'f'){
            System.out.println( df.format(Double.parseDouble(args[0]) * 9d/5d + 32d) + " \u00B0F");
        }
    }
    public static boolean checkValue(String arg){
        if(arg.isEmpty()) return false;
        try {
            Double.parseDouble(arg);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean checkFlag(String arg){
        if(arg.isEmpty() || arg.charAt(0) != '-') return false;
        return arg.toLowerCase().charAt(1) == 'c' || arg.toLowerCase().charAt(1) == 'f';
    }
}
