public class Fila {
    private final String[] fila;
    private int frente;
    private int tras;
    private int tamanho;
    private final int capacidade;

    public Fila(int tamanho) {
        fila = new String[tamanho];
        frente = 0;
        tras = -1;
        this.tamanho = 0;
        this.capacidade = tamanho;
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == capacidade;
    }

    public void enfileirar(String valor) throws Exception {
        try {
            if (estaCheia()) {
                throw new Exception("Fila cheia.");
            } else {
                tras = (tras + 1) % capacidade;
                fila[tras] = valor;
                tamanho++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String desenfileirar() {
        try {
            if (estaVazia()) {
                throw new Exception("Fila vazia.");
            } else {
                String valor = fila[frente];
                frente = (frente + 1) % capacidade;
                tamanho--;
                return valor;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
