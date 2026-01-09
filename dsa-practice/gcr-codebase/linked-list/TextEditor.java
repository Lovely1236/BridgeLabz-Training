class TextNode {
    String text;
    TextNode prev, next;

    TextNode(String text) {
        this.text = text;
    }
}

class TextEditor {
    TextNode current;
    int size = 0;
    final int LIMIT = 10;

    public void addState(String text) {
        TextNode node = new TextNode(text);

        if (current != null) {
            current.next = node;
            node.prev = current;
        }

        current = node;
        size++;
    }

    public void undo() {
        if (current != null && current.prev != null)
            current = current.prev;
    }

    public void redo() {
        if (current != null && current.next != null)
            current = current.next;
    }

    public void display() {
        System.out.println("Current Text: " + current.text);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");

        editor.display();
        editor.undo();
        editor.display();
        editor.redo();
        editor.display();
    }
}