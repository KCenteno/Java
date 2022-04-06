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
        if (this.isEmpty()) {
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
list.removeBack();
list.print(list);





 
//  // EXTRA
//  /**
//   * Recursively finds the maximum integer data of the nodes in this list.
//   * - Time: O(?).
//   * - Space: O(?).
//   * @param {ListNode} runner The start or current node during traversal, or null
//   *    when the end of the list is reached.
//   * @param {ListNode} maxNode Keeps track of the node that contains the current
//   *    max integer as it's data.
//   * @returns {?number} The max int or null if none.
//   */
//  recursiveMax(runner = this.head, maxNode = this.head) {}


// class Node{
//     constructor(data){
//         this.data = data;
//         this.next = null;
//     }
// }


// class singlyLinkedList{
//     constructor(){
//         this.head = null;
//     }

//     addToFront(data){
//         let newNode = new Node(data);
//         if(this.head === null){
//             this.head = newNode;
//             return;
//         }
//         newNode.next = this.head;
//         this.head = newNode;
//     }

//     addToBack(data){
//         if(this.head === null){
//             this.addToFront(data);
//             return;
//         }
//         let newNode = new Node(data);
//         let runner = this.head;
//         while(runner.next != null){
//             runner = runner.next;
//         }
//         runner.next = newNode;
//     }

//     addToBackN(arr){
//         let i = 0;
//         if(this.head === null){
//             this.head = new Node(arr[i]);
//             i++;
//         }
//         let runner = this.head;
//         while(runner.next != null){
//             runner = runner.next;
//         }

//         while(i < arr.length){
//             let newNode = new Node(arr[i]);
//             runner.next = newNode;
//             runner = runner.next;
//             i++;
//         }
//     }

//     removeFromFront(){
//         if(this.head === null){
//             return;
//         }
//         this.head = this.head.next;
//     }

//     toString(){
//         if(this.head === null) return;
//         console.log("Running toString: ");
//         let myStr = "";
//         let runner = this.head;
//         while(runner !== null){
//             myStr += runner.data + " -> ";
//             runner = runner.next;
//         }
//         console.log(myStr + " null");
//     }

//     isEmpty(){
//         if(this.head === null){
//             return true;
//         }
//         return false;
//     }

// }

// let mySll = new singlyLinkedList();
// mySll.toString();
// console.log(mySll.isEmpty());
// mySll.addToFront(32);
// // mySll.addToFront(64);
// // mySll.addToFront(128);
// // mySll.addToFront(256);
// mySll.addToBack(512);
// console.log(mySll.isEmpty());
// mySll.addToBackN([111,222,333,444,555]);
// // mySll.removeFromFront();
// mySll.toString();