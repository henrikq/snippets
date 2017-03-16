"""Just playing with exceptions."""


def _raise_sequentially():
    try:
        raise Exception("1. exception")
    except Exception:
        raise Exception('2. exception')
    except:
        raise Exception('3. exception')


try:
    _raise_sequentially()
except Exception as exception:
    print exception
# 2. exception


def _raise_sequentially_pass():
    try:
        raise Exception("1. exception")
    except Exception:
        pass
    except:
        raise Exception('3. exception')


try:
    _raise_sequentially_pass()
    print "it passed"
except Exception as exception:
    print exception
# it passed


def _raise_sequentially_nested():
    try:
        raise Exception("1. exception, nested")
    except Exception:
        _raise_sequentially()
    except:
        raise Exception('3. exception, nested')


try:
    _raise_sequentially_nested()
    print "it passed"
except Exception as exception:
    print exception
# it passed


def _raise_then_raise():
    try:
        raise Exception("1. exception")
    except Exception:
        raise


try:
    _raise_then_raise()
    print "it passed"
except Exception as exception:
    print exception
# 1. exception
