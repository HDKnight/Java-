

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;


public class AStar {
    private int[][] map;//��ͼ(1��ͨ�� 0����ͨ��)
    private List<Node> openList;//�����б�
    private List<Node> closeList;//�ر��б�
    private final int COST_STRAIGHT = 19;//��ֱ�����ˮƽ�����ƶ���·������
    private final int COST_DIAGONAL = 19;//б�����ƶ���·������
    private int row;//��
    private int column;//��
    int i=1;
    static Vector<Integer> a = new Vector<Integer>(30);
    static Vector<Integer> b = new Vector<Integer>(30);
    public AStar(int[][] map,int row,int column){
        this.map=map;
        this.row=row;
        this.column=column;
        openList=new ArrayList<Node>();
        closeList=new ArrayList<Node>();
    }
    
    //�������꣨-1������0��û�ҵ���1���ҵ��ˣ�
    public int search(int x1,int y1,int x2,int y2){
    	
        if(x1<0||x1>=row||x2<0||x2>=row||y1<0||y1>=column||y2<0||y2>=column){
            return -1;
        }
        if(map[x1][y1]==0||map[x2][y2]==0){
            return -1;
        }
        Node sNode=new Node(x1,y1,null);
        Node eNode=new Node(x2,y2,null);
        openList.add(sNode);
        List<Node> resultList=search(sNode, eNode);
        if(resultList.size()==0){
            return 0;
        }
        for(Node node:resultList){
            map[node.getX()][node.getY()]=-1;
            Test.x2.add(node.getX());
			Test.y2.add(node.getY());
			i++;
        }
        return 1;
    }
    
    //���Һ����㷨
    private List<Node> search(Node sNode,Node eNode){
        List<Node> resultList=new ArrayList<Node>();
        boolean isFind=false;
        Node node=null;
        while(openList.size()>0){
            //ȡ�������б������Fֵ������һ���洢��ֵ��FΪ��͵�
            node=openList.get(0);
            //�ж��Ƿ��ҵ�Ŀ���
            if(node.getX()==eNode.getX()&&node.getY()==eNode.getY()){
                isFind=true;
                break;
            }
            //��
            if((node.getY()-1)>=0){
                checkPath(node.getX(),node.getY()-1,node, eNode, COST_STRAIGHT);
            }
            //��
            if((node.getY()+1)<column){
                checkPath(node.getX(),node.getY()+1,node, eNode, COST_STRAIGHT);
            }
            //��
            if((node.getX()-1)>=0){
                checkPath(node.getX()-1,node.getY(),node, eNode, COST_STRAIGHT);
            }
            //��
            if((node.getX()+1)<row){
                checkPath(node.getX()+1,node.getY(),node, eNode, COST_STRAIGHT);
            }
            //����
            if((node.getX()-1)>=0&&(node.getY()-1)>=0){
                checkPath(node.getX()-1,node.getY()-1,node, eNode, COST_DIAGONAL);
            }
            //����
            if((node.getX()-1)>=0&&(node.getY()+1)<column){
                checkPath(node.getX()-1,node.getY()+1,node, eNode, COST_DIAGONAL);
            }
            //����
            if((node.getX()+1)<row&&(node.getY()-1)>=0){
                checkPath(node.getX()+1,node.getY()-1,node, eNode, COST_DIAGONAL);
            }
            //����
            if((node.getX()+1)<row&&(node.getY()+1)<column){
                checkPath(node.getX()+1,node.getY()+1,node, eNode, COST_DIAGONAL);
            }
            //�ӿ����б���ɾ��
            //��ӵ��ر��б���
            closeList.add(openList.remove(0));
            //�����б������򣬰�Fֵ��͵ķŵ���׶�
            Collections.sort(openList, new NodeFComparator());
        }
        if(isFind){
            getPath(resultList, node);
        }
        return resultList;
    }
    
    //��ѯ��·�Ƿ�����ͨ
    private boolean checkPath(int x,int y,Node parentNode,Node eNode,int cost){
        Node node=new Node(x, y, parentNode);
        //���ҵ�ͼ���Ƿ���ͨ��
        if(map[x][y]==0){
            closeList.add(node);
            return false;
        }
        //���ҹر��б����Ƿ����
        if(isListContains(closeList, x, y)!=-1){
            return false;
        }
        //���ҿ����б����Ƿ����
        int index=-1;
        if((index=isListContains(openList, x, y))!=-1){
            //Gֵ�Ƿ��С�����Ƿ����G��Fֵ
            if((parentNode.getG()+cost)<openList.get(index).getG()){
                node.setParentNode(parentNode);
                countG(node, eNode, cost);
                countF(node);
                openList.set(index, node);
            }
        }else{
            //��ӵ������б���
            node.setParentNode(parentNode);
            count(node, eNode, cost);
            openList.add(node);
        }
        return true;
    }
    
    //�������Ƿ����ĳ��Ԫ��(-1��û���ҵ������򷵻����ڵ�����)
    private int isListContains(List<Node> list,int x,int y){
        for(int i=0;i<list.size();i++){
            Node node=list.get(i);
            if(node.getX()==x&&node.getY()==y){
                return i;
            }
        }
        return -1;
    }
    
    //���յ������ص����
    private void getPath(List<Node> resultList,Node node){
        if(node.getParentNode()!=null){
            getPath(resultList, node.getParentNode());
        }
        resultList.add(node);
    }
    
    //����G,H,Fֵ
    private void count(Node node,Node eNode,int cost){
        countG(node, eNode, cost);
        countH(node, eNode);
        countF(eNode);
    }
    //����Gֵ
    private void countG(Node node,Node eNode,int cost){
        if(node.getParentNode()==null){
            node.setG(cost);
        }else{
            node.setG(node.getParentNode().getG()+cost);
        }
    }
    //����Hֵ
    private void countH(Node node,Node eNode){
        node.setF(Math.abs(node.getX()-eNode.getX())+Math.abs(node.getY()-eNode.getY()));
    }
    //����Fֵ
    private void countF(Node node){
        node.setF(node.getG()+node.getF());
    }
    
}