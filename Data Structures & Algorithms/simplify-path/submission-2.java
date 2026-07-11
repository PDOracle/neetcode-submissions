class Solution {
    public String simplifyPath(String path) {
        StringBuilder sPath = new StringBuilder();
        String[] comp = path.split("/");
        System.out.println(Arrays.toString(comp));
        Stack<String> pBuild = new Stack<>();
        for(int i = 0; i < comp.length; i++){
            if(comp[i].equals("") || comp[i].equals(".")){
                continue;
            }
            else if(comp[i].equals("..")){
                if(!pBuild.isEmpty()){
                    pBuild.pop();
                }
            }
            else{
                pBuild.push(comp[i]);
            }
        }
        if(pBuild.isEmpty()){
            sPath.append("/");
        }
        while(!pBuild.isEmpty()){
            sPath.insert(0, "/" + pBuild.pop());
        }
        return sPath.toString();
    }
}