class Solution {
public:

    bool check(int v, vector<int> &vis, vector<int> &pathVis, vector<vector<int>> &graph, vector<int> &safeNodes){
        vis[v] = 1;
        pathVis[v] = 1;
        for(auto i : graph[v]){
            if(!vis[i]){
                    if(check(i,vis,pathVis,graph,safeNodes)==true){
                        safeNodes[i]=0;
                        return true;
                    }
                }
                if(pathVis[i]){
                    safeNodes[i]=0;
                    return true;
                }
        }
        pathVis[v] = 0;
        safeNodes[v] = 1;
        return false;
    }


    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int V = graph.size();
        vector<int> vis(V,0);
        vector<int> pathVis(V,0);
        vector<int> safeNodes(V,0);
        vector<int> ans;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                check(i,vis,pathVis,graph,safeNodes);
            }
        }
        for(int i=0;i<V;i++){
            if(safeNodes[i]==1){
                ans.push_back(i);
            }
        }
        return ans;
    }
};
