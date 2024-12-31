package zeirenlian;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new ManagerHandler());
        chain.addHandler(new DirectorHandler());
        chain.addHandler(new CEOHandler());
        chain.process(new Request("Bob", new BigDecimal("123.45")));
        chain.process(new Request("Tom", new BigDecimal("1888.56")));
        chain.process(new Request("Alice", new BigDecimal("1234.56")));
        chain.process(new Request("Bill", new BigDecimal("12345.67")));
        chain.process(new Request("John", new BigDecimal("123456.78")));
    }
}
