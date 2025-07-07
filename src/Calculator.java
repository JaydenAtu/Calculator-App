import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
    public JFrame frame;
    private final JTextField textField;
    private final JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[40];
    private final JButton addButton, subButton, mulButton, divButton, modButton, secButton, sqButton, cubButton, sqrtButton;
    private final JButton decButton, equButton, delButton, clrButton, negButton, pwrButton, expButton, antilgButton, invButton;
    private final JButton leftBracButton, rightBracButton, mcButton, mplusButton, mminusButton, mrButton, cubrtButton, rtButton;
    private final JButton lnButton, logButton, facButton, sinButton, tanButton, cosButton, eButton, eeButton, radButton, piButton;
    private final JButton sinhButton, tanhButton, coshButton, randButton;
    public JPanel panel;

    public Font myFont = new Font("Arial",Font.BOLD,20);

    private double num1 =0, num2=0, result=0;
    private char operator;

    private boolean secondFunction = false;

    public Calculator(){ // Front-end of the calculator
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1014,552);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(10,25,980,50);
        textField.setFont(myFont);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");
        negButton = new JButton("+/-");
        modButton = new JButton("%");
        secButton = new JButton("2nd");
        sqButton = new JButton("x²");
        cubButton = new JButton("x³");
        sqrtButton = new JButton("√");
        pwrButton = new JButton("xʸ");
        expButton = new JButton("eˣ");
        antilgButton = new JButton("10ˣ");
        invButton = new JButton("1/x");
        leftBracButton = new JButton("(");
        rightBracButton = new JButton(")");
        mcButton = new JButton("mc");
        mplusButton = new JButton("m+");
        mminusButton = new JButton("m-");
        mrButton = new JButton("mr");
        cubrtButton = new JButton("³√");
        rtButton = new JButton("ˣ√");
        lnButton = new JButton("ln");
        logButton = new JButton("log");
        facButton = new JButton("x!");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        eButton = new JButton("e");
        eeButton = new JButton("EE");
        radButton = new JButton("Rad");
        sinhButton = new JButton("sinh");
        coshButton = new JButton("cosh");
        tanhButton = new JButton("tanh");
        piButton = new JButton("π");
        randButton = new JButton("Rand");

        // assigning the buttons numbers for easy assigning of colors and font
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = modButton;
        functionButtons[10] = secButton;
        functionButtons[11] = sqButton;
        functionButtons[12] = cubButton;
        functionButtons[13] = sqrtButton;
        functionButtons[14] = pwrButton;
        functionButtons[15] = expButton;
        functionButtons[16] = antilgButton;
        functionButtons[17] = invButton;
        functionButtons[18] = leftBracButton;
        functionButtons[19] = rightBracButton;
        functionButtons[20] = mcButton;
        functionButtons[21] = mplusButton;
        functionButtons[22] = mminusButton;
        functionButtons[23] = mrButton;
        functionButtons[24] = cubrtButton;
        functionButtons[25] = rtButton;
        functionButtons[26] = lnButton;
        functionButtons[27] = logButton;
        functionButtons[28] = facButton;
        functionButtons[29] = sinButton;
        functionButtons[30] = cosButton;
        functionButtons[31] = tanButton;
        functionButtons[32] = eButton;
        functionButtons[33] = eeButton;
        functionButtons[34] = radButton;
        functionButtons[35] = sinhButton;
        functionButtons[36] = coshButton;
        functionButtons[37] = tanhButton;
        functionButtons[38] = piButton;
        functionButtons[39] = randButton;

        for(int i = 7; i<40;i++){
            functionButtons[i].setBackground(Color.DARK_GRAY);
            functionButtons[i].setForeground(Color.WHITE);

        }
        for(int i = 0; i<7;i++){
            functionButtons[i].setBackground(Color.ORANGE);
        }
        for(int i = 0;i<40;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for(int i = 0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.GRAY);
            numberButtons[i].setForeground(Color.WHITE);
        }

        panel = new JPanel();
        panel.setBounds(10, 75, 980, 400);
        panel.setLayout(new GridLayout(5,10,2,2));
        panel.setBackground(Color.BLACK);

        // adding the buttons to the panel in specific order
        panel.add(leftBracButton);
        panel.add(rightBracButton);
        panel.add(mcButton);
        panel.add(mplusButton);
        panel.add(mminusButton);
        panel.add(mrButton);
        panel.add(clrButton);
        panel.add(negButton);
        panel.add(modButton);
        panel.add(divButton);
        panel.add(secButton);
        panel.add(sqButton);
        panel.add(cubButton);
        panel.add(pwrButton);
        panel.add(expButton);
        panel.add(antilgButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(invButton);
        panel.add(sqrtButton);
        panel.add(cubrtButton);
        panel.add(rtButton);
        panel.add(lnButton);
        panel.add(logButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(facButton);
        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(eButton);
        panel.add(eeButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(radButton);
        panel.add(sinhButton);
        panel.add(coshButton);
        panel.add(tanhButton);
        panel.add(piButton);
        panel.add(randButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);
        panel.add(delButton);

        frame.add(panel);
        frame.add(textField);
        frame.setVisible(true);
    }

    public void setNum1(double num1){
        this.num1 = num1;
    }
    public void setNum2(double num2){
        this.num2 = num2;
    }
    public void setResult(double result){
        this.result = result;
    }
    public void setOperator(char operator){
        this.operator = operator;
    }
    public void setTextFieldValue(String text){
        textField.setText(text);
    }

    public double getNum1(){
        return num1;
    }
    public double getNum2(){
        return num2;
    }
    public double getResult(){
        return result;
    }
    public char getOperator(){
        return operator;
    }
    public String getTextFieldValue(){
        return textField.getText();
    }

    // Back-end of the calculator
    public long calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case: 0! = 1! = 1
        }
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    public double customRoot(double x, double n) {
        return Math.pow(x, 1.0 / n);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i =0;i<10;i++){
            if(e.getSource() == numberButtons[i]){
                setTextFieldValue(getTextFieldValue().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            setTextFieldValue(getTextFieldValue().concat("."));
        }
        if(e.getSource()==addButton){
            setNum1(Double.parseDouble(getTextFieldValue()));
            setOperator('+');
            setTextFieldValue("");
        }
        if(e.getSource()==subButton){
            setNum1(Double.parseDouble(getTextFieldValue()));
            setOperator('-');
            setTextFieldValue("");
        }
        if(e.getSource()==mulButton){
            setNum1(Double.parseDouble(getTextFieldValue()));
            setOperator('x');
            setTextFieldValue("");
        }
        if(e.getSource()==divButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            setOperator('÷');
            setTextFieldValue("");
        }
        if(e.getSource() == modButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            setOperator('%');
            setTextFieldValue("");
        }
        if(e.getSource()==pwrButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            setOperator('^');
            setTextFieldValue("");
        }
        if(e.getSource()==rtButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            setOperator('r');
            setTextFieldValue("");
        }
        if(e.getSource()==equButton){
            setNum2(Double.parseDouble(getTextFieldValue()));

            switch(getOperator()){
                case '+':
                    setResult(getNum1() + getNum2());
                    break;
                case '-':
                    setResult(getNum1() - getNum2());
                    break;
                case 'x':
                    setResult(getNum1() * getNum2());
                    break;
                case '÷':
                    setResult(getNum1() / getNum2());
                    if (getNum2() == 0){
                        setTextFieldValue("Error: Division by zero");
                        return;
                    }
                    break;
                case '%':
                    setResult(getNum1() % getNum2());
                    break;
                case '^':
                    setResult(Math.pow(getNum1(), getNum2()));
                    break;
                case 'r':
                    if (getNum1() < 0 && getNum2() % 2 == 0) {
                        setTextFieldValue("Error");
                        return;
                    }
                    setResult(customRoot(getNum1(), getNum2()));
                    break;
            }
            if (Double.toString(getResult()).endsWith(".0")) {
                setTextFieldValue(Double.toString(getResult()).replace(".0",""));
            }else{
                setTextFieldValue(Double.toString(getResult()));
            }
            setNum1(getResult());
        }
        if(e.getSource()==clrButton){
            setTextFieldValue("");
        }
        if(e.getSource()==delButton){
            String string = getTextFieldValue();
            setTextFieldValue("");
            for(int i =0;i<string.length()-1;i++){
                setTextFieldValue(getTextFieldValue()+string.charAt(i));
            }
        }
        if(e.getSource()==negButton){
            double temp = Double.parseDouble(getTextFieldValue());
            temp*=-1;
            setTextFieldValue(String.valueOf(temp));
        }
        if(e.getSource()==sqButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double sq = Math.pow(getNum1(),2);
            String string = Double.toString(sq);
            if (string.endsWith(".0")){
                setTextFieldValue(string.replace(".0",""));
            }else{
                setTextFieldValue(string);
            }
        }
        if(e.getSource()==cubButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double cube = Math.pow(getNum1(),3);
            String string = Double.toString(cube);
            if (string.endsWith(".0")){
                setTextFieldValue(string.replace(".0",""));
            }else{
                setTextFieldValue(string);
            }
        }
        if(e.getSource()==sqrtButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double sqrt = Math.sqrt(getNum1());
            setTextFieldValue(String.valueOf(sqrt));
        }
        if(e.getSource()==cubrtButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double cubrt = Math.cbrt(getNum1());
            setTextFieldValue(String.valueOf(cubrt));
        }
        if(e.getSource()==invButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double inverse = 1 / getNum1();
            String string = Double.toString(inverse);
            if (string.endsWith(".0")){
                setTextFieldValue(string.replace(".0",""));
            }else{
                setTextFieldValue(string);
            }
        }
        if(e.getSource()==expButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double exp = Math.exp(getNum1());
            setTextFieldValue(String.valueOf(exp));
        }
        if(e.getSource()==lnButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double ln = Math.log(getNum1());
            setTextFieldValue(String.valueOf(ln));
        }
        if(e.getSource()==logButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double log = secondFunction ? (Math.log(getNum1()) / Math.log(2)) : Math.log10(getNum1());
            setTextFieldValue(String.valueOf(log));
        }
        if(e.getSource()==antilgButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double antiLog = Math.exp(getNum1() * Math.log(10));
            setTextFieldValue(String.valueOf(antiLog));
        }
        if(e.getSource() == piButton) {
            setTextFieldValue(String.valueOf(Math.PI));
        }
        if(e.getSource() == eButton){
            setTextFieldValue(String.valueOf(Math.E));
        }
        if(e.getSource()==sinButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double sin = secondFunction ? Math.toDegrees(Math.asin(getNum1())) : Math.sin(Math.toRadians(getNum1()));
            setTextFieldValue(String.valueOf(sin));
        }
        if(e.getSource()==cosButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double cos = secondFunction ? Math.toDegrees(Math.acos(getNum1())) : Math.cos(Math.toRadians(getNum1()));
            setTextFieldValue(String.valueOf(cos));
        }
        if(e.getSource()==tanButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double tan = secondFunction ? Math.toDegrees(Math.atan(getNum1())) : Math.tan(Math.toRadians(getNum1()));
            setTextFieldValue(String.valueOf(tan));
        }
        if(e.getSource()==sinhButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double sinh = Math.sinh(Math.toRadians(getNum1()));
            setTextFieldValue(String.valueOf(sinh));
        }
        if(e.getSource()==coshButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double cosh = Math.cosh(Math.toRadians(getNum1()));
            setTextFieldValue(String.valueOf(cosh));
        }
        if(e.getSource()==tanhButton){
            setNum1( Double.parseDouble(getTextFieldValue()));
            double tanh = Math.tanh(Math.toRadians(getNum1()));
            setTextFieldValue(String.valueOf(tanh));
        }
        if(e.getSource()==facButton){
            try {
                setNum1( Double.parseDouble(getTextFieldValue()));
                if (getNum1() < 0 || getNum1() % 1 != 0) {
                    setTextFieldValue("Error");
                } else {
                    long factorial = calculateFactorial((int) getNum1());
                    setTextFieldValue(String.valueOf(factorial));
                }
            }
            catch(NumberFormatException ex){
                setTextFieldValue("Error: Invalid Input");
            }
            catch (Exception ex) {
                setTextFieldValue("Error");
            }
        }
        if(e.getSource() == secButton){
            secondFunction = !secondFunction;

            if(secondFunction){
                sinButton.setText("sin ̄ ¹");
                cosButton.setText("cos ̄ ¹");
                tanButton.setText("tan ̄ ¹");
                logButton.setText("logշ");
            }else {
                sinButton.setText("sin");
                cosButton.setText("cos");
                tanButton.setText("tan");
                logButton.setText("log");
            }
        }
    }
}

