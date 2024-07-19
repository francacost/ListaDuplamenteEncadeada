package brenner.costa;

public class Main {

    public static void main(String [] args){
        ListaDuplamenteEncadeada<String> minhaListaDpEncadeada = new ListaDuplamenteEncadeada<String>();

        minhaListaDpEncadeada.add("ca");
        minhaListaDpEncadeada.add("cb");
        minhaListaDpEncadeada.add("cc");
        minhaListaDpEncadeada.add("cd");
        minhaListaDpEncadeada.add("ce");

        System.out.println(minhaListaDpEncadeada);

        minhaListaDpEncadeada.remove(2);

        System.out.println(minhaListaDpEncadeada);
    }
}
