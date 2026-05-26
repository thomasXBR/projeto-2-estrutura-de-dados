// Thomas Barbosa Bulhões - 10427456
// Enzo Grutila de Oliveira - 10737003


package apl2;

public class DLinkedList
{

    private Node head;
    private Node tail;
    private int count;


    // OPERAÇÃO:		Método construtor
// COMPORTAMENTO:	Cria uma lista vazia.
    public DLinkedList()
    {
        head = null;
        tail = null;
        count = 0;
    }


    // OPERAÇÃO:		insert(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no início da lista.
    public void insert(String id, String name, float grade)
    {
        Node newNode = new Node(id, name, grade);

        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }

        count++;
    }


    // OPERAÇÃO:		append(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no final da lista.
    public void append(String id, String name, float grade)
    {
        Node newNode = new Node(id, name, grade);

        if (isEmpty())
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }

        count++;
    }


    // OPERAÇÃO: 		removeHead()
// COMPORTAMENTO:	Remove o nó do início da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
    public Node removeHead()
    {
        // TODO: Implementar o método e remover o lançamento de exceção abaixo.

        if (isEmpty())
        {
            return null;
        }
        else if (count == 1)
        {
            Node removed = head;
            head = null;     // head avança pro próximo
            tail = null;          // novo head não tem anterior
            count--;
            return removed;
        }
        else
        {
            Node removed = head;
            head = head.getNext();        // head avança pro próximo
            head.setPrev(null);           // novo head não tem anterior
            removed.setNext(null);        // nó removido não aponta pra ninguém
            count--;
            return removed;
        }
    }


    // OPERAÇÃO:		removeTail()
// COMPORTAMENTO:	Remove o nó do final da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
    public Node removeTail()
    {
        if (isEmpty())
        {
            return null;
        }
        else if (count == 1)
        {
            Node removed = tail;
            head = null;     // head avança pro próximo
            tail = null;          // novo head não tem anterior
            count--;
            return removed;
        }
        else
        {
            Node removed = tail;
            tail = tail.getPrev();        // head avança pro próximo
            tail.setNext(null);           // novo head não tem anterior
            removed.setPrev(null);        // nó removido não aponta pra ninguém
            count--;
            return removed;
        }
    }


    // OPERAÇÃO:		removeNode(<ID da pessoa>)
// COMPORTAMENTO:	Remove o nó que contém o <ID da pessoa> da lista e retorna
//					a referência do nó removido.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
    public Node removeNode(String id)
    {
        Node current = head;
        while (current != null)
        {
            if (current.getId().equals(id))
            {
                if (current == head)
                    return removeHead();
                else if (current == tail)
                    return removeTail();
                else {
                    current.getPrev().setNext(current.getNext());
                    current.getNext().setPrev(current.getPrev());
                    current.setNext(null);
                    current.setPrev(null);
                    count--;
                    return current;
                }
            }
            current = current.getNext();
        }
        return null; // não achou
    }

    // OPERAÇÃO:		getHead()
// COMPORTAMENTO:	Retorna uma referência para o nó do início da lista.
//					Ou retorna null caso a lista esteja vazia.
    public Node getHead() {
        return head;
    }


    // OPERAÇÃO:		getTail()
// COMPORTAMENTO:	Retorna uma referência para o nó do final da lista.
//					Ou retorna null caso a lista esteja vazia.
    public Node getTail() {
        // TODO: Implementar o método e remover o lançamento de exceção abaixo.
        return tail;
    }


    // OPERAÇÃO:		getNode(<ID da pessoa>)
// COMPORTAMENTO:	Retorna uma referência para o nó que contém o <ID da pessoa>
//					da lista.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
    public Node getNode(String id) {
        Node current = head;
        while (current != null) {
            if (current.getId().equals(id)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }


    // OPERAÇÃO:		count()
// COMPORTAMENTO:	Retorna a quantidade de nós da lista.
    public int count() {
        // TODO: Implementar o método e remover o lançamento de exceção abaixo.
        return count;
    }


    // OPERAÇÃO:		isEmpty()
// COMPORTAMENTO:	Retorna true se a lista estiver vazia ou false, caso contrário.
    public boolean isEmpty() {
        // TODO: Implementar o método e remover o lançamento de exceção abaixo.
        return count == 0;
    }


    // OPERAÇÃO:		clear()
// COMPORTAMENTO:	Esvazia a lista, liberando a memória de todos os nós da lista.
    public void clear() {
        // TODO: Implementar o método e remover o lançamento de exceção abaixo.
        head = null;
        tail = null;
        count = 0;
    }


    // OPERAÇÃO:		toString()
// COMPORTAMENTO:	Retorna uma string com o conteúdo da lista (caso queira, use o
//					exemplo do método toString() da classe LinkedListOriginal).
    @Override
    public String toString() {
        String result = "(" + count + ")\n";
        Node current = head;
        while (current != null) {
            result += current.toString() + "\n";
            current = current.getNext();
        }
        return result;
    }

}