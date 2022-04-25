// create node class
class Node {
    constructor(value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
};

// create listclass
class DoublyLinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.size = 0;

        return this
    }
    
    insertAtFront(value) {
        this.size++
        var newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return this
        }
        newNode.next = this.head;
        this.head.previous = newNode;
        this.head = newNode;
        
        return this
    }

    /**
     * Creates a new node and adds it at the back of this list.
     * @param {any} data The data for the new node.
     * @returns {DoublyLinkedList} This list.
     */
    insertAtBack(value) {
        var newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return this
        }
        else {newNode.previous = this.tail;
        this.tail.next = newNode;
        this.tail = newNode;
        }
        this.size++
        
        return this
    }

    removeMiddleNode() {
        console.log(this.size)
        this.size -= 1;
        var half = Math.ceil(this.size / 2);
        var counter = 0;
        var runner = this.head

        while (counter != half) {
            runner = runner.next
            counter++
        }
        var temp = runner.next
        temp.previous = runner.previous
        temp = runner.previous
        temp.next = runner.next
        console.log("Middle value : " + runner.value);
        runner.next = null
        runner.previous = null
    }

    /**
     * Determines if this list is empty.
     * @returns {boolean} Indicates if this list is empty.
     */
    isEmpty() {
        if (this.head == null) {
            return this.head === null;
        }
    }

    print() {
        let result = "";
        let runner = this.head;
        while (runner != null) {
            result += `${runner.value} ⇶ `;
            runner = runner.next;
        }
        console.log(result.slice(0, result.length - 2));
    }
}



let emptyList = new DoublyLinkedList();


emptyList.insertAtFront(12);
emptyList.insertAtFront(13);
emptyList.insertAtFront(14);
emptyList.insertAtFront(15);
emptyList.print(emptyList);
console.log(emptyList);