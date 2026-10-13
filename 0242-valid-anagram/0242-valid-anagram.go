func isAnagram(s string, t string) bool {
     runes := []rune(s)
     runet := []rune(t)
      
      slices.Sort(runes)
      slices.Sort(runet)

      return  string(runes) == string(runet);
}