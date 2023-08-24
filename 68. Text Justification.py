class Solution:
    def fullJustify(self, words, maxWidth):
        lines = self.constructLines(words, maxWidth)
        lines = self.addSpaces(lines, maxWidth)
        lines = list(map(lambda x : "".join(x), lines))
        return lines
    
    def constructLines(self, words, maxWidth):
        lines = []
        
        # Construct words per line
        wordLensInPara = list(map(len, words))
        i, j = 0, 0
        while i < len(words):
            while j < len(words):
                totalWordLen, numSpaces = sum(wordLensInPara[i:j+1]), (j-i)
                width = totalWordLen + numSpaces
                if width > maxWidth: break
                else: j += 1
            lines.append(words[i:j])
            i = j
        
        return lines
    
    def addSpaces(self, lines, maxWidth):
        for line in lines:
            numWords = len(line)
            lineLen = sum(map(len, line))
            numSpaces = maxWidth - lineLen
            
            # Standard line
            if lines.index(line) < len(lines)-1:
                if numWords == 1: # One word
                    line[0] += " " * numSpaces
                else: # Multiple words
                    numSpacesPerWord, extraSpaces = divmod(numSpaces,numWords-1)
                    for i in range(len(line)-1):
                        line[i] += " " * numSpacesPerWord

                        if extraSpaces > 0:
                            line[i] += " "
                            extraSpaces -= 1
            # Last line
            else:
                for i in range(len(line)-1):
                    line[i] += " "
                    numSpaces -= 1
                line[-1] += " " * numSpaces
            
        return lines
