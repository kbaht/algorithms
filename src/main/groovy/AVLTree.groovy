class AVLNode {
    def key
    int height
    AVLNode parent
    AVLNode left = null
    AVLNode right = null

    AVLNode(key, AVLNode parent) {
        this.key = key
        this.parent = parent
    }

    def height(AVLNode node) {
        if (node == null) {
            return -1
        } else {
            return node.height
        }
    }

    def updateHeight(AVLNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1
    }

    def rebalance(node) {
        while (node != null) {
            updateHeight(node)
            if (height(node.left) >= 2 + height(node.right)) {
                if (height(node.left.left) >= height(node.left.right)) {
                    this.rightRotate(node)
                } else {
                    this.leftRotate(node.left)
                    this.rightRotate(node)
                }
            } else if (height(node.right) >= 2 + height(node.left)) {
                if (height(node.right.right) >= height(node.right.left)) {
                    this.leftRotate(node)
                } else {
                    this.rightRotate(node.left)
                    this.leftRotate(node)
                }
            }
            node = node.parent
        }
    }

    def rightRotate(AVLNode node) {
        node.left.parent = node.parent
        if (node.parent.right == node) {
            node.parent.right = node.left
        } else {
            node.parent.left = node.left
        }
        node.left.right = node
        node.parent = node.left
        node.left = node.left.right
        node.left.parent = node
    }

    def leftRotate(AVLNode node) {
        node.right.parent = node.parent
        if (node.parent.right == node) {
            node.parent.right = node.right
        } else {
            node.parent.left = node.right
        }
        node.right.left = node
        node.parent = node.right
        node.right = node.right.left
        node.right.parent = node
    }
}
