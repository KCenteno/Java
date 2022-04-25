class StackNode {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack {
    constructor() {
        this.head = null;
        this.tail = null;
    }
}
class Stack {
    /**
     * The constructor is executed when instantiating a new Stack() to construct
     * a new instance.
     * @returns {Stack} This new Stack instance is returned without having to
     *    explicitly write 'return' (implicit return).
     */
    constructor() {
        this.items = [];
        this.size = 0;
    }

    /**
     * Returns whether or not this stack is empty.
     * @returns {boolean}
     */
    isEmpty() {
        if (this.head == null) {
            console.log("This ting empty!")
            return true
        }
        console.log("This is not empty!")
        return false
    }

    /**
     * Adds a new given item to the top / back of this stack.
     * @param {any} item The new item to be added to the top / back.
     * @returns {number} The new length of this stack.
     */
    push(item) {
        var newItem = new StackNode(item)
        if (this.head == null) {
            this.head = newItem;
            this.tail = newItem;
            console.log("New Head/Tail pushed: ", newItem.data)
            this.size++
            return this
        }
        var runner = this.head
        while (runner.next) {
            runner = runner.next
        }
        runner.next = newItem
        this.size++
        console.log("Item pushed: ", newItem.data)
        return this
    }
    /**
         * Removes the top / last item from this stack.
         * @returns {any} The removed item or undefined if this stack was empty.
         */
    pop() {
        if (this.head == null) {
            console.log("this thing empty")
            return this
        }
        var runner = this.head
        var tail = this.tail
        while (runner.next.next) {
            runner = runner.next
        }
        console.log("Poppin: ", runner.next.data)
        runner.next = null;
        runner = tail
        this.size--
    }

    /**
     * Retrieves the top / last item from this stack without removing it.
     * @returns {any} The top / last item of this stack.
     */
    peek() {
        if (this.head == null) {
            console.log("this thing empty")
            return this
        }
        var runner = this.head
        while (runner.next) {
            runner = runner.next
        }
        console.log("Peek A Boo: ", runner.data)
        return runner.data
    }

    /**
     * Returns the size of this stack.
     * @returns {number} The length.
     */
    stackSize() {
        console.log("Size: ", this.size)
        return this.size
    }

    print() {
        let result = "";
        let runner = this.head;
        while (runner != null) {
            result += `${runner.data} ⇶ `;
            runner = runner.next;
        }
        console.log(result.slice(0, result.length - 2));
    }
}

const stacklist = new Stack();


stacklist.isEmpty()
stacklist.push(6)
stacklist.push(8)
stacklist.push(10)
stacklist.push(12)
stacklist.push(14)
stacklist.isEmpty()
console.log("===============================")
stacklist.print()
stacklist.peek()
stacklist.stackSize()
stacklist.pop()
console.log("===============================")
stacklist.print()
stacklist.peek()
stacklist.stackSize()
stacklist.pop()
console.log("===============================")
stacklist.print()
stacklist.peek()
stacklist.stackSize()