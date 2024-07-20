import unittest
from multiply import multiply


class MultiplyTest(unittest.TestCase):
    def test_multiply(self):
        self.assertEqual(multiply(3, 2), 6)
        self.assertEqual(multiply(-1, 1), -1)
        self.assertEqual(multiply(-1, -1), 1)
        self.assertEqual(multiply(0, 0), 0)


if __name__ == '__main__':
    unittest.main()
