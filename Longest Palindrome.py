class Solution:
    def longestPalindrome(self, s: str) -> int:
        # Initialize a set to keep track of characters with odd frequencies
        char_set = set()
        # Initialize the length of the longest palindrome
        length = 0
        
        # Iterate over each character in the string
        for char in s:
            # If the character is already in the set, remove it and increase the length by 2
            if char in char_set:
                char_set.remove(char)
                length += 2
            # If the character is not in the set, add it to the set
            else:
                char_set.add(char)
        
        # If there are any characters left in the set, add 1 to the length for the middle character
        if char_set:
            length += 1
        
        # Return the total length of the longest palindrome
        return length
