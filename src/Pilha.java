public class Pilha {
    private final String[] pilha;
    private int topo;
    private final int capacidade;

    public Pilha(int tamanho) {
        pilha = new String[tamanho];
        topo = -1;
        capacidade = tamanho;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean estaCheia() {
        return topo == capacidade - 1;
    }

    public void empilhar(String valor) throws Exception {
        try {
            if (estaCheia()) {
                throw new Exception("Pilha cheia.");
            } else {
                pilha[++topo] = valor;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String desempilhar() {
        try {
            if (estaVazia()) {
                throw new Exception("Pilha vazia.");
            } else {
                return pilha[topo--];
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
