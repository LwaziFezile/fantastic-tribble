class ZigZagConversion :
        def convert(self, s: str, numRows: int) -> str:
            if numRows == 1:
                return s
            if numRows % 2 == 0:
                population = (numRows * 2) - 1
            else:
                population = (numRows * 2) + 1
            zigZagList = [[] for x in range(numRows)]
            char_position = 0
            row = 0
            row_reverse = numRows - 1
            for i in s:
                if row < numRows:
                    zigZagList[row].append(i)  
                    row += 1
                else:
                    char_position += 1
                    row_reverse -= 1
                    zigZagList[row_reverse].append(i)
                if row_reverse == 0:
                    row_reverse = numRows - 1
                    row = 1
            zigZagString = ""
            for i in zigZagList:
                zigZagString += "".join(i)
            return zigZagString
