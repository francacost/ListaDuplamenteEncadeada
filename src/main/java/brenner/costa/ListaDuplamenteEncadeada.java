package brenner.costa;

public class ListaDuplamenteEncadeada<T> {
    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public T get(int index) {
        verificarIndice(index);
        return this.getNo(index).getConteudo();
    }

    public void add(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(null);
        novoNo.setNoPrevio(ultimoNo);

        if (primeiroNo == null) {
            primeiroNo = novoNo;
        }
        if (ultimoNo != null) {
            ultimoNo.setNoProximo(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista++;
    }

    public void add(int index, T elemento) {
        verificarIndice(index);
        if (index == tamanhoLista) {
            add(elemento);
            return;
        }

        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(noAuxiliar);
        novoNo.setNoPrevio(noAuxiliar.getNoPrevio());

        if (novoNo.getNoPrevio() != null) {
            novoNo.getNoPrevio().setNoProximo(novoNo);
        } else {
            primeiroNo = novoNo;
        }

        if (novoNo.getNoProximo() != null) {
            novoNo.getNoProximo().setNoPrevio(novoNo);
        } else {
            ultimoNo = novoNo;
        }

        tamanhoLista++;
    }

    public void remove(int index) {
        verificarIndice(index);
        if (index == 0) {
            primeiroNo = primeiroNo.getNoProximo();
            if (primeiroNo != null) {
                primeiroNo.setNoPrevio(null);
            }
        } else {
            NoDuplo<T> noAuxiliar = getNo(index);
            noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
            if (noAuxiliar != ultimoNo) {
                noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
            } else {
                ultimoNo = noAuxiliar.getNoPrevio();
            }
        }
        this.tamanhoLista--;
    }

    private NoDuplo<T> getNo(int index) {
        NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i = 0; (i < index) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    private void verificarIndice(int index) {
        if (index < 0 || index >= tamanhoLista) {
            throw new IndexOutOfBoundsException("Índice fora dos limites: " + index);
        }
    }

    public int size() {
        return this.tamanhoLista;
    }

    @Override
    public String toString() {
        StringBuilder strRetorno = new StringBuilder();
        NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i = 0; i < size(); i++) {
            if (noAuxiliar == null) {
                break;
            }
            strRetorno.append("[No{conteudo=").append(noAuxiliar.getConteudo()).append("}]-->");
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        strRetorno.append("null");
        return strRetorno.toString();
    }
}
