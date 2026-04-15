package edu.kis.vh.nursery.list;

/**
 * Prosta jednokierunkowa lista liczb całkowitych z operacjami stosu.
 */
public class IntLinkedList {
    private static final int EMPTY_LIST_INDICATOR = -1;
    private static final int DEFAULT_RETURN_VALUE = -1;
    private Node lastNode;
    private int i;

    /**
     * Dodaje nowy element na koniec listy.
     *
     * @param i wartość do dodania
     */
    public void push(int i) {
        if (lastNode == null)
            lastNode = new Node(i);
        else {
            lastNode.setNext(new Node(i));
            lastNode.getNext().setPrev(lastNode);
            lastNode = lastNode.getNext();
        }
    }

    /**
     * Sprawdza, czy lista jest pusta.
     *
     * @return true, jeśli lista nie zawiera elementów
     */
    public boolean isEmpty() {
        return lastNode == null;
    }

    /**
     * Sprawdza, czy lista jest pełna.
     *
     * @return zawsze false, bo lista jest dynamiczna
     */
    public boolean isFull() {
        // TODO: jeśli ta lista ma mieć prawdziwe ograniczenie, to tutaj powinna być normalna implementacja.
        // TODO: jeśli nie ma ograniczenia, to ta metoda jest właściwie zbędna.
        return false;
    }

    /**
     * Zwraca wartość z końca listy bez jej usuwania.
     *
     * @return ostatnia wartość albo -1, gdy lista jest pusta
     */
    public int top() {
        if (isEmpty())
            return DEFAULT_RETURN_VALUE;
        return lastNode.getValue();
    }

    /**
     * Usuwa i zwraca wartość z końca listy.
     *
     * @return ostatnia wartość albo -1, gdy lista jest pusta
     */
    public int pop() {
        if (isEmpty())
            return DEFAULT_RETURN_VALUE;
        int ret = lastNode.getValue();
        lastNode = lastNode.getPrev();
        return ret;
    }

}

/**
 * Węzeł przechowujący pojedynczą wartość oraz odwołania do sąsiednich węzłów.
 */
class Node {
    private final int value;
    private Node prev, next;

    /**
     * Tworzy nowy węzeł z podaną wartością.
     *
     * @param number wartość przechowywana w węźle
     */
    public Node(int number) {
        this.value = number;
    }

    /**
     * Zwraca następny węzeł.
     *
     * @return następny węzeł albo null
     */
    public Node getNext() {
        return next;
    }

    /**
     * Ustawia następny węzeł.
     *
     * @param next następny węzeł
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Zwraca poprzedni węzeł.
     *
     * @return poprzedni węzeł albo null
     */
    public Node getPrev() {
        return prev;
    }

    /**
     * Ustawia poprzedni węzeł.
     *
     * @param prev poprzedni węzeł
     */
    public void setPrev(Node prev) {
        this.prev = prev;
    }

    /**
     * Zwraca przechowywaną wartość.
     *
     * @return wartość węzła
     */
    public int getValue() {
        return value;
    }

}