import unittest
from sum import sum


class SumTest(unittest.TestCase):
    def test_sum(self):
        self.assertEqual(sum(3, 2), 5)
        self.assertEqual(sum(-1, 1), 0)
        self.assertEqual(sum(-1, -1), -2)
        self.assertEqual(sum(0, 0), 0)


if __name__ == '__main__':
    unittest.main()
