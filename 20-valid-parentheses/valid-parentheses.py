class Solution:
    def isValid(self, s: str) -> bool:
        l=[]
        if len(s)%2==1:
            return False
        for i in s:
            if i=='(' or i=='{' or i=='[':
                l.append(i)
            else:
                if l==[]:
                    return False
                elif i=='}' and l[-1]!='{':
                    return False
                elif i==']' and l[-1]!='[':
                    return False
                elif i==')' and l[-1]!='(':
                    return False
                else:
                    l.pop()
        else:
            if(l!=[]):
                return False
            else:
                return True