public class SkillTreeNode {
    SkillTreeNode[] child;
    String skillName;
 
    public SkillTreeNode() {
 
        // skill defined by 6 keys. 2 4 6 8 A B
        child = new SkillTreeNode[8];
 
    }
 
    public SkillTreeNode addNode(char queryChar) {
 
        int index = SkillTreeNode.getIndex(queryChar);
        
        if (-1 == index) {
            return null;
        }
 
        if (child[index] == null) {
            child[index] = new SkillTreeNode();
        }
        return child[index];
    }
 
    public void setSkillName(String aSkillName) {
        if (null != aSkillName && aSkillName.length() > 0) {
            this.skillName = aSkillName;
        }
    }
    
    public static int getIndex(char queryChar) {
        
        if ('2' == queryChar) {
            return 0;
        } else if ('4' == queryChar) {
            return 1;
        } else if ('6' == queryChar) {
            return 2;
        } else if ('8' == queryChar) {
            return 3;
        } else if ('A' == queryChar) {
            return 4;
        } else if ('B' == queryChar) {
            return 5;
        } else if ('C' == queryChar) {
            return 6;
        } else if ('D' == queryChar) {
            return 7;
        } else {
            return -1;
        }
        
    }}
