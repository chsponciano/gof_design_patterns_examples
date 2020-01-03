package behavioralPattern;

interface Expression {
    public boolean understand(String context);
}

class FinalExpression implements Expression {
    private String data;

    public FinalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean understand(String context) {
        return context.contains(this.data);
    }
}

class ExpressionAnd implements Expression {
    private Expression expr1 = null, expr2 = null;

    public ExpressionAnd(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean understand(String context) {
        return this.expr1.understand(context) && this.expr2.understand(context);
    }
}

class ExpressionOr implements Expression {
    private Expression expr1 = null, expr2 = null;

    public ExpressionOr(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean understand(String context) {
        return this.expr1.understand(context) || this.expr2.understand(context);
    }
}

public class Interpreter {
    public Expression loadAuthor(String author1, String author2) {
        return new ExpressionOr(new FinalExpression(author1), new FinalExpression(author2));
    }

    public Expression loadLanguage(String person) {
        return new ExpressionAnd(new FinalExpression(person), new FinalExpression("Java"));
    }

    public static void main(String[] args) {
        new Interpreter().execute();
    }

    public void execute() {
        Expression authors = loadAuthor("Fernando", "Anselmo");
        Expression knowledge = loadLanguage("Fernando");

        System.out.println("Fernando foi o autor deste curso? "
                + authors.understand("Fernando Autor"));

        System.out.println("Fernando sabe Java? "
                + knowledge.understand("Fernando Java"));
    }
}
