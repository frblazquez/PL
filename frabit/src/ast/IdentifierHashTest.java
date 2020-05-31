//// TODO: Either move this to a test folder (could prove useful in the future) or delete
//package ast;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.util.HashMap;
//
//import org.junit.jupiter.api.Test;
//
//
//class IdentifierHashTest {
//
//	@Test
//	void test() {
//		HashMap<Identifier, Integer> hm = new HashMap<Identifier, Integer>();
//		Identifier id1 = new Identifier("a");
//		Identifier id2 = new Identifier("a");
//		if (!id1.equals(id2)) fail("Should've been equal");
//		if (id1.hashCode() != id2.hashCode()) fail("Hashcodes should've been equal");
//		hm.put(id1, 3);
//		System.out.println(String.valueOf(hm.get(id2)));
//	}
//
//}
