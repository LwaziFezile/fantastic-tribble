class ZigZagConversion :
    """
        A class to perform ZigZag Conversion of a given string based on a specified number of rows.
    """
        def convert(self, s: str, numRows: int) -> str:
        """
            Converts the input string into a ZigZag pattern on a given number of rows,
            and then reads line by line to produce a new string.

            Args:
                s (str): The input string to be converted.
                numRows (int): The number of rows to use for the ZigZag pattern.

            Returns:
                str: The string formed by reading the ZigZag pattern line by line.
        """
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
