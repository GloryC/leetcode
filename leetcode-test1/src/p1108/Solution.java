package p1108;

/**
 * @author Glory
 * @date 2019/10/15 9:04
 */
public class Solution {

    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

}
