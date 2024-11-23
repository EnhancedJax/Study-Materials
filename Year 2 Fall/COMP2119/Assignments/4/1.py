class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
        self.parent = None


class BST:
    def __init__(self):
        self.root = None

    def insert(self, node):
        if self.root is None:
            self.root = node
        else:
            current = self.root
            while True:
                if node.value < current.value:
                    if current.left is None:
                        current.left = node
                        node.parent = current
                        break
                    else:
                        current = current.left
                else:
                    if current.right is None:
                        current.right = node
                        node.parent = current
                        break
                    else:
                        current = current.right


def find_lowest_common_ancestor(root, node1, node2):
    current = root
    # works by traversing the tree from the root to the node where the values of the two nodes are on either side of the current node
    while True:
        if node1.value < current.value and node2.value < current.value:
            current = current.left
        elif node1.value > current.value and node2.value > current.value:
            current = current.right
        else:
            return current


def check_is_avl(root):
    def _get_height_subtree(node):
        if node is None:
            return 0
        return 1 + max(_get_height_subtree(node.left), _get_height_subtree(node.right))

    return abs(_get_height_subtree(root.left) - _get_height_subtree(root.right)) <= 1


if __name__ == "__main__":
    bst = BST()
    bst.insert(TreeNode(20))
    bst.insert(TreeNode(8))
    bst.insert(TreeNode(22))
    bst.insert(TreeNode(4))
    bst.insert(TreeNode(12))
    bst.insert(TreeNode(10))
    bst.insert(TreeNode(14))

    """
    The tree looks like this:
        20
       /  \
      8    22
     / \
    4  12
         / \
        10 14
    
    """

    print(
        find_lowest_common_ancestor(
            bst.root, bst.root.left.left, bst.root.left.right.right
        ).value  # finding the lowest common ancestor of 4 and 14
    )

    avl = BST()
    avl.insert(TreeNode(20))
    avl.insert(TreeNode(10))
    avl.insert(TreeNode(30))
    avl.insert(TreeNode(5))
    avl.insert(TreeNode(15))
    avl.insert(TreeNode(25))
    avl.insert(TreeNode(35))

    """
    The tree looks like this:
        20
       /  \
      10   30
     / \   / \
    5  15 25 35
    """

    print(check_is_avl(bst.root))  # checking if the tree is an AVL tree
    print(check_is_avl(avl.root))  # checking if the tree is an AVL tree
