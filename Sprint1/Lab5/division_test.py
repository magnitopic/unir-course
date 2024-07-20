import unittest
from division import division


class DivisionTest(unittest.TestCase):
    def test_division(self):
        self.assertEqual(division(3, 2), 1.5)
        self.assertEqual(division(-1, 1), -1)
        self.assertEqual(division(-1, -1), 1)
        self.assertEqual(division(0, 0), "undefined")


if __name__ == '__main__':
    unittest.main()
