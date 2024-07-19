package brenner.costa;

public class NoDuplo<T> {

    private T conteudo;
    private NoDuplo<T> noProximo;
    private NoDuplo<T> noPrevio; // Corrigido: o nome estava como 'noprevio'

    public NoDuplo(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoDuplo<T> getNoProximo() {
        return noProximo;
    }

    public void setNoProximo(NoDuplo<T> noProximo) {
        this.noProximo = noProximo;
    }

    public NoDuplo<T> getNoPrevio() {
        return noPrevio; // Corrigido: o nome estava como 'noprevio'
    }

    public void setNoPrevio(NoDuplo<T> noPrevio) {
        this.noPrevio = noPrevio; // Corrigido: o nome estava como 'noprevio'
    }

    @java.lang.Override
    public String toString() {
        return "NoDuplo{" + "conteudo=" + conteudo + "}";
    }
}
