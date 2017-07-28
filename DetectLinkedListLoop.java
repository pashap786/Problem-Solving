class DetectLinkedListLoop
{
 int detectLoop(Node head)
  {
        Node node=head;
        Map<Node, Integer> map = new HashMap<Node,Integer>();
        while(node.next!=null){
            if(map.size()==0){
                map.put(node,node.data);
            }
            else if(map.get(node)==null){
                map.put(node,node.data);
            }
            else if(map.get(node.next)!=null){
                return 1;
            }
            node = node.next;
        }
      
        return 0;
    }
}