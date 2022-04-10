class Node
{
    constructor(value)
    {
        this.next=null;
        this.value=value;
    }
};

class List
{
    constructor()
    {
        this.head=null;
    }

    /* Determine whether the list is empty. */
    IsEmpty()
    {
        if( this.head == this.tail && this.head == null){
            return true
        }
    }

    /* Insert a node with the given value to the end of the list */
    PushBack(value){
    var newNode = new Node(value);
    if (!this.head) {
        this.head = newNode;
    } else {
        var runner = this.head;
        while (runner.next != null) {
            runner = runner.next;
        }
        runner.next = newNode;
    }
    return this.head;
}

    /* Insert an array of nodes with the given values to the end of the list. */
    PushBackN(arr) {
        for(let i = 0; i <arr.length; i++){
            this.PushBack(arr[i])
        }
        return this;
    }


    insertAtFront(data) {
        if (!this.head) {
            return -1;
        }
        let temp = new Node(data);
        temp.next = this.head;
        this.head = temp;
    }

    removeHead() {
        let temp = this.head;
        this.head = this.head.next;
        temp.next = null;
    }

    average() {
        let temp = this.head;
        let sum = 0;
        let ct = 0;
        while (temp.next != null) {
            sum += temp.value;
            ct++;
            temp = temp.next;
        }
        return sum / ct;
    }

    removeBack() {
        if (this.IsEmpty()) {
            return null;
        }

        // Only 1 node.
        if (this.head.next === null) {
            return this.removeHead();
        }

        // More than 1 node.
        let runner = this.head;

        while (runner.next.next) {
            runner = runner.next;
        }

        // after while loop finishes, runner is now at 2nd to last node
        const removedData = runner.next.data;
        runner.next = null; // remove it from list
        return removedData;
    }

    contains(val) {
        var runner=this.head
        while(runner){
            if ( runner.value === val){
            console.log("True")
            return true
            }
            runner = runner.next;
        }
            console.log ("False")
            return false
    }

    containsRecursive(val, current = this.head) {
        if (current === null) {
            return false;
        }
        if (current.data === val) {
            return true;
        }
        return this.containsRecursive(val, current.next);
    }

    recursiveMax(runner = this.head, maxNode = this.head) {
        if (this.head === null) {
            return null;
        }

        if (runner === null) {
            return maxNode.data;
        }

        if (runner.data > maxNode.data) {
            maxNode = runner;
        }

        return this.recursiveMax(runner.next, maxNode);
    }

    secondToLast() {
        if (this.head == null || this.head.next == null) {
            console.log("List is too short! Cannot return second to last!");
            // return 'this' to end function and allow chaining of methods
            return this;
        }
        var runner = this.head;
        while (runner.next.next != null) {
            runner = runner.next;
        }
        return runner.value;
    }

    removeVal(val) {
        if (this.IsEmpty()) {
            return null;
        }
        let runner = this.head;
        while(runner.next) {
            if(runner.next.value === val){
                runner.next = runner.next.next
            }
            runner = runner.next;
        }
        return this.head
    }


    prepend(newVal, targetVal) {
        let newNode = new Node(newVal)
        if(this.head==null){
            this.head == newNode
            return;
        }
        if (targetVal == 0) {
            this.addToFront(newVal)
        }
        var count = 0;
        var runner = this.head;
        while(runner) {
            if (count == targetVal-1) {
                newNode.next = runner.next
                runner.next = newNode
                return this;
            }
            runner = runner.next
            count++;
        }
        return false;
    }

    concat(addList) {
        let runner = this.head;

        if (runner === null) {
            this.head = addList.head;
        } else {
            while (runner.next) {
                runner = runner.next;
            }
            runner.next = addList.head;
        }
        return this;
    }

    moveMinToFront() {
        if (this.isEmpty()) {
            return this;
        }

        let minNode = this.head;
        let runner = this.head;
        let prev = this.head;

        // Todo refactor to while runner.next
        while (runner.next) {
            if (runner.next.data < minNode.data) {
                prev = runner;
                minNode = runner.next;
            }

            runner = runner.next;
        }

        if (minNode === this.head) {
            return this;
        }

        prev.next = minNode.next;
        minNode.next = this.head;
        this.head = minNode;
        return this;
    }

    splitOnVal(val) {
        const newList = new SinglyLinkedList();

        if (!this.head) {
            return newList;
        }

        if (this.head.data === val) {
            newList.head = this.head;
            this.head = null;
            return newList;
        }

        let runner = this.head;

        while (runner.next) {
            if (runner.next.data === val) {
                newList.head = runner.next;
                runner.next = null;
                return newList;
            }
            runner = runner.next;
        }
        return newList;
    }

    print(){
        let result = "";
        let runner = this.head;
        while(runner != null){
            result += `${runner.value} 👉 ⇶✨`; 
            runner = runner.next;
        }
        console.log(result.slice(0, result.length - 6));
    }

};

let test_data1=123;
let test_data2=234;
let test_data3=345;
let test_data4=[111,222,333,444,555];

/* Create our list */
let list=new List();
/* Insert nodes into the list: */
list.PushBack(test_data1);
list.PushBack(test_data2);
list.PushBack(test_data3);
list.PushBackN(test_data4);
// console.log(list.average());
// list.contains(321);
// list.removeBack();
// list.secondToLast();
list.removeVal(345);
// list.prepend(456, 5);
list.print(list);
