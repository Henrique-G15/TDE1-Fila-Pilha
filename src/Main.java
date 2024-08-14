import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Pilha pilhaExecucao = new Pilha(6);
        Fila filaTarefas = new Fila(5);

        // Empilhando funções na pilha
        pilhaExecucao.empilhar("Iniciar sistema");
        pilhaExecucao.empilhar("Verificar tarefas na fila");
        pilhaExecucao.empilhar("Adicionando tarefas na fila");
        pilhaExecucao.empilhar("Acionar fila");
        pilhaExecucao.empilhar("Executar tarefas da fila");
        pilhaExecucao.empilhar("Desligar sistema");

        while (true) {
            System.out.println("Pressione o enter para ligar");
            scanner.nextLine();

            executarSistema(pilhaExecucao, filaTarefas, scanner);

            System.out.println("\nDeseja desligar o sistema? (sim/nao)");
            String resposta = scanner.nextLine().toLowerCase();

            if (resposta.equals("sim")) {
                while (!pilhaExecucao.estaVazia()) {
                    String tarefa = pilhaExecucao.desempilhar();
                    if (tarefa.equals("Desligar sistema")) {
                        System.out.println("Desligando o sistema...");
                    }
                }
                break;
            } else {
                System.out.println("Executando tarefa: Reiniciar o Sistema");
                // O sistema reinicia, mas a fila é mantida
            }
        }
    }

    public static void executarSistema(Pilha pilhaExecucao, Fila filaTarefas, Scanner scanner) throws Exception {
        // Função 1: Ligar o sistema
        System.out.println("Executando tarefa: ligando o sistema");

        // Função 2: Verificar tarefas na fila
        System.out.println("Executando tarefa: Verificar tarefas na fila");
        if (filaTarefas.estaVazia()) {
            System.out.println("Fila: Vazia");
        } else {
            System.out.println("Fila: Cheia");
        }

        // Pergunta se deseja adicionar tarefas à fila
        System.out.println("\nDeseja adicionar tarefas na fila? (sim/nao)");
        String resposta = scanner.nextLine().toLowerCase();

        if (resposta.equals("sim")) {
            while (!filaTarefas.estaCheia()) {
                System.out.print("Adicione a tarefa a fila :");
                String tarefa = scanner.nextLine();
                filaTarefas.enfileirar(tarefa);

                if (filaTarefas.estaCheia()) {
                    System.out.println("Fila: Cheia");
                    break;
                }
                System.out.println("Fila: Nao esta cheia");
            }
        } else {
            System.out.println("Executando tarefa: Adicionando tarefas a fila ");
            // Caso escolha não adicionar, adiciona automaticamente tarefas fictícias
            for (int i = 1; i <= 5; i++) {
                if (!filaTarefas.estaCheia()) {
                    filaTarefas.enfileirar("Tarefa " + i);
                }
            }
            System.out.println("Fila: Cheia");
        }

        // Função 3: Acionar fila
        System.out.println("Executando tarefa: Acionar fila");
        while (!filaTarefas.estaVazia()) {
            String tarefaFila = filaTarefas.desenfileirar();
            System.out.println("Tarefa processada: " + tarefaFila);
        }

        // Função 4: Executar as tarefas empilhadas até restar a função de desligar
        System.out.println("Executando tarefa: Executar tarefas da fila");
        while (pilhaExecucao.estaCheia()) {
            String tarefaPilha = pilhaExecucao.desempilhar();
            if (tarefaPilha.equals("Desligar sistema")) {
                System.out.println("Preparando para desligar...");
            } else {
                System.out.println("Executando: " + tarefaPilha);
            }
        }
    }
}