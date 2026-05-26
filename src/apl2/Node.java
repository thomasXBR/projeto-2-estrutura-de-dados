// arquivo: src/apl2/Node.java

// TODO: Colocar a identificação dos(as) integrantes aqui.

// Thomas Barbosa Bulhões - 10427456
// Enzo Grutila de Oliveira - 10737003


package apl2;

// -- A classe Node (que pertence ao pacote apl2) deve conter os atributos que
// representam a nova versão dos dados de uma pessoa, conforme descrito no
// enunciado da atividade Apl2.
// -- A classe deve conter os construtores apropriados, assim como os métodos
// getters e setters.
// -- A classe também representa um nó que é usado na implementação da lista
// duplamente encadeada (classe DLinkedList).
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com os valores dos atributos da classe.

public class Node
{

    private String id;    // ex: "23.S1-111"
    private String name;  // ex: "Allana"
    private float grade;  // ex: 10.0 ou 99.9
    private Node next;    // ponteiro pro próximo
    private Node prev;    // ponteiro pro anterior


    // Getters e setters
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getGrade() {
        return grade;
    }
    public void setGrade(float grade) {
        this.grade = grade;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getPrev() {
        return prev;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node() {
        this(null, null, 0);
    }

    public Node(String id, String name, float grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString()
    {
        // Obtém o ID do nó anterior, ou "null" se não houver
        String prevId = (prev == null) ? "null" : prev.id;

        // Obtém o ID do próximo nó, ou "null" se não houver
        String nextId = (next == null) ? "null" : next.id;

        // Retorna o nó no formato: prevId <- (id; name; grade) -> nextId
        return prevId + " <- (" + id + "; " + name + "; " + grade + ") -> " + nextId;
    }
}

