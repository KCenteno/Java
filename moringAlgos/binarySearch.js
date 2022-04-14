/**
 * Class to represent a Node in a Binary Search Tree (BST).
 */
class BSTNode {
    /**
     * Constructs a new instance of a BST node.
     * @param {number} data The integer to store in the node.
     */
    constructor(data) {
        this.data = data;
        /**
         * These properties are how this node is connected to other nodes to form
         * the tree. Similar to .next in a SinglyLinkedList except a BST node can
         * be connected to two other nodes. To start, new nodes will not be
         * connected to any other nodes, these properties will be set after
         * the new node is instantiated.
         *
         * @type {BSTNode|null}
         */
        this.left = null;
        /** @type {BSTNode|null} */
        this.right = null;
    }
}

/**
 * Represents an ordered tree of nodes where the data of left nodes are <= to
 * their parent and the data of nodes to the right are > their parent's data.
 */
class BinarySearchTree {
    constructor() {
        /**
         * Just like the head of a linked list, this is the start of our tree which
         * branches downward from here.
         *
         * @type {BSTNode|null}
         */
        this.root = null;
    }

    /**
     * Determines if this tree is empty.
     * - Time: O(?).
     * - Space: O(?).
     * @returns {boolean} Indicates if this tree is empty.
     */
    isEmpty() {
        if(this.root == null){
            return true;
        }
        return false;
    }

    insert(newVal) {
        const node = new BSTNode(newVal)

        if (this.isEmpty()) {
            this.root = node
            return this
        }

        let current = this.root

        while (true) {
            if (newVal <= current.data) {
                if (!current.left) {
                    current.left = node
                    return this
                }

                current = current.left
            } else {
                // newVal is greater than current.data
                if (!current.right) {
                    current.right = node
                    return this
                }

                current = current.right
            }
        }
    }

    insertRecursive(newVal, current = this.root) {
        const node = new BSTNode(newVal)

        if (this.isEmpty()) {
            this.root = node
            return this
        }

        if(newVal <= current.data) {
            if(!current.left) {
                current.left = node
                return this
            }

            current = current.left

        } else {
            if (!current.right) {
                current.right = node
                return this
            }
            
            current = current.right
            
        }

        return this.insertRecursive(newVal, current)
    }

    /**
     * Retrieves the smallest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {number} The smallest integer from this tree.
     */
    min(current = this.root) {
        while(current.left){
            current = current.left
        }
        return current;
    }

    /**
     * Retrieves the smallest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {number} The smallest integer from this tree.
     */
    minRecursive(current = this.root) {
        // return node == null ? null : node.left == null ? node.data : this.minRecursive(node.left);
        if (current.left == null) {
            return current
        }
        return this.minRecursive(current.left)
    }

    /**
     * Retrieves the largest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {number} The largest integer from this tree.
     */
    max(current = this.root) {
        while(current.right){
            current = current.right
        }
        return current;
    }

    /**
     * Retrieves the largest integer data from this tree.
     * - Time: O(?).
     * - Space: O(?).
     * @param {Node} current The node that is currently accessed from the tree as
     *    the tree is being traversed.
     * @returns {number} The largest integer from this tree.
     */
    maxRecursive(current = this.root) {
        // return node == null ? null : node.right == null ? node.data : this.maxRecursive(node.right);
        if (current.right == null) {
            return current;
        }
        return this.maxRecursive(current.right);
    }

    /**
 * Determines if this tree contains the given searchVal.
 * @param {number} searchVal The number to search for in the node's data.
 * @returns {boolean} Indicates if the searchVal was found.
 */
    contains(searchVal) {
        if(current == null){
            return false;
        }
        let runner = this.root
        while(runner != null) {
            if(searchVal == runner.data){
                return true;
            }
            if(searchVal > runner.data){
                runner = runner.right
            }
            else{
                runner = runner.left
            }
        }
        return false;
    }

/**
 * Determines if this tree contains the given searchVal.
 * @param {number} searchVal The number to search for in the node's data.
 * @returns {boolean} Indicates if the searchVal was found.
 */

    containsRecursive(searchVal, current = this.root) {
        if(current == null){
            return false;
        }
            if(searchVal == current.data) {
                return true;
            }
            if(searchVal > current.data) {
                return this.containsRecursive(searchVal, current.right)
            }
            else if (searchVal < current.data) {
                return this.containsRecursive(searchVal, current.left)
            }
        return false
    }

    /**
 * DFS Preorder: (CurrNode, Left, Right)
 * Converts this BST into an array following Depth First Search preorder.
 * Example on the fullTree var:
 * [25, 15, 10, 4, 12, 22, 18, 24, 50, 35, 31, 44, 70, 66, 90]
 * @param {Node} node The current node during the traversal of this tree.
 * @param {Array<number>} vals The data that has been visited so far.
 * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
 */
    toArrPreOrder(node = this.root, vals = []){
        if(node == null){
            return;
        }

        vals.push(node.data);
        this.toArrPreOrder(node.left, vals);
        this.toArrPreOrder(node.right, vals);
        return vals;
    }

/**
 * DFS Inorder: (Left, CurrNode, Right)
 * Converts this BST into an array following Depth First Search inorder.
 * See debugger call stack to help understand the recursion.
 * Example on the fullTree var:
 * [4, 10, 12, 15, 18, 22, 24, 25, 31, 35, 44, 50, 66, 70, 90]
 * @param {Node} node The current node during the traversal of this tree.
 * @param {Array<number>} vals The data that has been visited so far.
 * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
 */
    toArrInorder(node = this.root, vals = []) {
        if(node == null){
            return;
        }

    this.toArrInOrder(node.left, vals);
    vals.push(node.data);
    this.toArrInOrder(node.right, vals);
    return vals;
}

/**
 * DFS Postorder (Left, Right, CurrNode)
 * Converts this BST into an array following Depth First Search postorder.
 * Example on the fullTree var:
 * [4, 12, 10, 18, 24, 22, 15, 31, 44, 35, 66, 90, 70, 50, 25]
 * @param {Node} node The current node during the traversal of this tree.
 * @param {Array<number>} vals The data that has been visited so far.
 * @returns {Array<number>} The vals in DFS Preorder once all nodes visited.
 */
    toArrPostOrder(node = this.root, vals = []){
    if(node == null){
        return;
    }

    this.toArrPostOrder(node.left, vals);
    this.toArrPostOrder(node.right, vals);
    vals.push(node.data);
    return vals;
}

/**
 * Calculates the range (max - min) from the given startNode.
 * @param {Node} startNode The node to start from to calculate the range.
 * @returns {number|null} The range of this tree or a sub tree depending on if the
 *    startNode is the root or not.
 */
    range(startNode = this.root) {
        if(startNode == null){
            return false;
        }
        let leftRunner = startNode;
        let rightRunner = startNode;
        while(leftRunner.left != null){
            leftRunner = leftRunner.left
        }
        while(rightRunner.right != null){
            rightRunner = rightRunner.right;
        }

        return rightRunner.data - leftRunner.data;
    }

    // Logs this tree horizontally with the root on the left.
    print(node = this.root, spaceCnt = 0, spaceIncr = 10) {
        if (!node) {
            return;
        }

        spaceCnt += spaceIncr;
        this.print(node.right, spaceCnt);

        console.log(
            " ".repeat(spaceCnt < spaceIncr ? 0 : spaceCnt - spaceIncr) +
            `${node.data}`
        );

        this.print(node.left, spaceCnt);
    }
}

const emptyTree = new BinarySearchTree();
const oneNodeTree = new BinarySearchTree();
oneNodeTree.root = new BSTNode(10);

/* twoLevelTree
        root
        10
      /   \
    5     15
*/
const twoLevelTree = new BinarySearchTree();
twoLevelTree.root = new BSTNode(10);
twoLevelTree.root.left = new BSTNode(5);
twoLevelTree.root.right = new BSTNode(15);

/* threeLevelTree 
        root
        10
      /   \
    5     15
  / \    / \
2   4  13  20
*/
const threeLevelTree = new BinarySearchTree();
threeLevelTree.root = new BSTNode(10);
threeLevelTree.root.left = new BSTNode(5);
threeLevelTree.root.left.left = new BSTNode(2);
threeLevelTree.root.left.right = new BSTNode(4);
threeLevelTree.root.right = new BSTNode(15);
threeLevelTree.root.right.right = new BSTNode(20);
threeLevelTree.root.right.left = new BSTNode(13);

/* fullTree
                    root
                <-- 25 -->
              /            \
            15             50
          /    \         /    \
        10     22      35     70
      /   \   /  \    /  \   /  \
    4    12  18  24  31  44 66  90
*/
/***************** Uncomment after insert method is created. ****************/
const fullTree = new BinarySearchTree();
//   fullTree
fullTree.insert(25)
fullTree.insert(15)
fullTree.insert(10)
fullTree.insert(22)
fullTree.insert(4)
fullTree.insert(12)
fullTree.insert(18)
fullTree.insert(24)
fullTree.insert(50)
fullTree.insert(35)
fullTree.insert(70)
fullTree.insert(31)
fullTree.insert(44)
fullTree.insert(66)
fullTree.insert(90);
fullTree.insertRecursive(100);
// console.log(fullTree.insertRecursive(100));
// fullTree.print()
// console.log(fullTree)
// console.log(fullTree.min())
console.log(fullTree.max())
// console.log(fullTree.minRecursive())
// console.log(fullTree.maxRecursive())
// console.log(fullTree.contains(1))
// console.log(fullTree.containsRecursive(1))
// console.log(fullTree.containsRecursive(90))
// console.log(fullTree.containsRecursive(4))
// console.log(fullTree.range())