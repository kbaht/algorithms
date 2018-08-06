class BinaryNode {
    def key
    BinaryNode parent
    BinaryNode left = null
    BinaryNode right = null

    BinaryNode(key, BinaryNode parent) {
        this.key = key
        this.parent = parent
    }

    BinaryNode findNode(key) {
        if (key == this.key) return this
        else if (key < this.key) {
            if (this.left == null) return null
            else return this.left.findNode(key)
        } else {
            if (this.right == null) return null
            else return this.right.findNode(key)
        }
    }

    def addNode(BinaryNode node) {
        if (node == null) return

        if (node.key < this.key) {
            if (this.left == null) {
                node.parent = this
                this.left = node
            } else {
                this.left.addNode(node)
            }
        } else {
            if (this.right == null) {
                node.parent = this
                this.right = node
            } else {
                this.right.addNode(node)
            }
        }
    }

    BinaryNode findMin() {
        def current = this
        while (current.left != null) {
            current = current.left
        }
        return current
    }

    BinaryNode nextLarger() {
        if (this.right != null) {
            return this.right.findMin()
        }
        def current = this
        while (current.parent != null && current == current.parent.right) {
            current = current.parent
        }
        return current.parent
    }

    def delete() {
        if (this.left == null || this.right == null) {
            if (this == this.parent.left) {
                this.parent.left = this.left ?: this.right
                if (this.parent.left != null) {
                    this.parent.left.parent = this.parent
                }
            } else {
                this.parent.right = this.right ?: this.left
                if (this.parent.right != null) {
                    this.parent.right.parent = this.parent
                }
            }
        } else {
            def node = this.nextLarger()
            def temp = this.key
            this.key = node.key
            node.key = temp
            node.delete()
        }
    }
}