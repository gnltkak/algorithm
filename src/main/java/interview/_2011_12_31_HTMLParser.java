package interview;

import java.util.Stack;

/*
 * input:
 *   text(String)
 * 
 * find:
 *   text가 valid 한 HTML 인지 아닌지를 리턴
 *   그리고 구현한 method를 test 할 수 있는 test case들을 제공하고
 *   각 test case가 어떤 결과를 내야 하고 구현된 method는 실제로 어떤 결과를 리턴하는지 표시 
 * 
 * constraint:
 *   "<br/>" 과 같은 태그는 고려하지 않아도 됨(open tag와 close tag가 같이 있는 경우)
 *   "<div id=...>" 과 같은 태그는 고려하지 않아도 됨(모든 tag는 속성을 가지지 않음)
 *   text의 모든 문자는 ascii code임
 */
public class _2011_12_31_HTMLParser {
	public static boolean isValidHTML(String text) {
		//return isValidHTML2012_11_05(text);
        return isValidHTML2016_03_04(text);
		
		/*
		Stack<String> st = new Stack<String>();
		int i = 0;
		while (i < text.length()) {
			char ch = text.charAt(i);
			if (ch == '>')
				return false;
			if (ch == '<') {
				i = getTag(text, i, st);
				if (i < 0)
					return false;
				continue;
			}
			++i;
		}
		
		return st.empty();
		*/
	}

	private static int getTag(String text, int i, Stack<String> st) {
		if (i + 2 >= text.length())
			return -1;
		
		int p = i + 1;
		while (p < text.length() && text.charAt(p) != '>')
			++p;
		if (p == text.length())
			return -1;
		
		if (text.charAt(i+1) == '/') {
			String tagName = text.substring(i + 2, p);
			if (tagName.isEmpty() || !st.peek().equals(tagName))
				return -1;
			st.pop();
		} else {
			String tagName = text.substring(i + 1, p);
			if (tagName.isEmpty())
				return -1;
			st.push(tagName);
		}
		
		return p + 1;
	}
	
	////////////////////////////////////////////////////////////////////////
	private static boolean isValidHTML2012_11_05(String html) {
		int n = html.length();
		int i = 0;
		Stack<String> tagSt = new Stack<String>();
		while (i < n) {
			char ch = html.charAt(i);
			if (ch == '<') {
				i = parseOneTag(html, i, tagSt);
				if (i == -1) return false;
			} else if (ch == '>' || ch == '/') return false;
			++i;
		}
		return tagSt.empty();
	}

	private static int parseOneTag(String html, int i, Stack<String> tagSt) {
		int n = html.length();
		if (i == n - 1 || i == n - 2) return -1;
		char ch = html.charAt(i + 1);
		if (ch != '/') {
			int j = i + 1;
			while (html.charAt(j) != '>') {
				if (html.charAt(j) == '/') return -1;
				++j;
				if (j == n) return -1;
			}
			if (j == i + 1) return -1;
			tagSt.push(html.substring(i + 1, j));
			return j;
		} else {
			int j = i + 2;
			while (html.charAt(j) != '>') {
				if (html.charAt(j) == '/') return -1;
				++j;
				if (j == n) return -1;
			}
			if (j == i + 2) return -1;
			String tag = html.substring(i + 2, j);
			if (!tagSt.peek().equals(tag)) return -1;
			tagSt.pop();
			return j;
		}
	}

	////////////////////////////////////////////////////////////////////////
	private static boolean isValidHTML2016_03_04(String text) {
		int n = text.length();
        Stack<String> tagStack = new Stack<String>();
        int i = 0;
        while (i < n) {
            char ch = text.charAt(i);
            if (ch == '<') {
                i = parseTagName(text, i, tagStack);
                if (i < 0) {
                    return false;
                }                
            } else if (ch == '>') {
                return false;
            } else {
                if (tagStack.empty()) return false;
                ++i;
            }
        }
        return tagStack.size() == 0;
	}

    private static int parseTagName(String text, int s, Stack<String> tagStack) {
        boolean close = false;
        int n = text.length();
        int l = s + 1;
        int r = l;
        if (l == n) return -1;
        if (text.charAt(l) == '/') {
            ++l;
            r = l;
            close = true;
        }
        while (l < n && r < n) {
            if (text.charAt(r) == '>') break;
            ++r;
        }
        if (l == r || r == n) return -1;
        String tagName = text.substring(l, r);
        if (!close) {
            tagStack.push(tagName);
        } else {
            if (tagStack.empty()) return -1;
            String openedTagName = tagStack.pop();
            if (!openedTagName.equals(tagName)) return -1;            
        }
        return r + 1;
    }
}

/*
 * O(n) 알고리즘
 * 보는 순간 stack을 써야함이 떠오를 것이다. 다만 구현이 간단하지가 않다.
 * 한 글자씩 읽으며 진행해도 되지만 구현이 매우 복잡하다. (state를 관리해야 하므로..)
 * 구현을 간단하게 하기 위해서 tag 하나를 하나의 덩어리로 취급하면 된다.
 * 여러가지 boundary case에 세심하게 주의해야 한다.
 * 
 * limitation:
 *   문제는 valid한 html 인지를 체크하는 것이므로
 *   tag name이 valid한 tag name인지 아닌지 체크하는 로직이 필요(lookup table 필요)
 *   (tag name에 space 같은게 들어가도 valid 하다고 해버림)
 *   위에 구현된 로직은 단순히 html의 구조만을 체크하는 것임
 */