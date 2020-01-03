package behavioralPattern;

interface Network {
    String typeNetwork();
}

class Linux implements Network {

    @Override
    public String typeNetwork() {
        return "Network Linux";
    }
}

class Microsoft implements Network {

    @Override
    public String typeNetwork() {
        return "Network Microsoft";
    }
}

class WebServer {
    private WebServer next;
    private String name;

    public WebServer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WebServer: " + this.name;
    }

    public void add(WebServer next) {
        if (this.next != null) {
            this.next.add(next);
        } else {
            this.next = next;
        }
    }

    public void wrapAround(WebServer first) {
        if (this.next != null) {
            this.next.wrapAround(first);
        } else {
            this.next = first;
        }
    }

    public void handle(Network network) {
        if ((int) (Math.random() * 4) % 2 == 0) {
            System.out.println("WebServer Conectado - " + network.typeNetwork() + " em " + this.next);
        } else {
            System.out.println("WebServer " + this.next + " Ocupado... Acessando outro novamente...");
            this.next.handle(network);
        }
    }
}

public class ChainOfResponsability {
    public static void main(String[] args) {
        new ChainOfResponsability().manager();
    }

    public void manager(){
        WebServer ws = new WebServer("WS Principal");
        WebServer one = new WebServer("WS1");
        ws.add(one);
        ws.add(new WebServer(("WS2")));
        ws.add(one);

        Network[] networks = {new Linux(), new Linux(), new Microsoft()};
        for(Network network : networks){
            ws.handle(network);
        }
    }
}
